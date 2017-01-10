package com.finleash.batch.springdatabatch.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finleash.batch.springdatabatch.persist.MutualFundNav;
import com.finleash.batch.springdatabatch.persist.MutualFundNavRepository;

/**
 * 
 * @author viqkhan
 *
 */
@Component
public class FileUtil {

	private final static Logger log = LoggerFactory.getLogger(FileUtil.class);

	@Autowired
	MutualFundNavRepository mutualFundNavRepository;

	private final String _URL = "http://portal.amfiindia.com/spages/NAV0.txt";
	// Window
	private final String _FILE_PATH_WINDOW = "C:\\home\\FileLanding\\";
	private final String ARCHIVE_PATH_WINDOW = "c:\\home\\FileArchive\\";
	// Unix
	private final String _FILE_PATH_UNIX = "home\\FileLanding\\";
	private final String ARCHIVE_PATH_UNIX = "home\\FileArchive\\";

	/**
	 * 
	 * @param args
	 */

	public void initiateMutualFundNavETL() {
		long startTime = System.nanoTime();
		String filPath = "";
		String archivePath = "";
		try {
			log.debug(
					"------------------------------------------------------------------------------------------------------------------------------");
			log.debug(
					"-----------------------------------FileUtil.initiateMutualFundNavETL Start----------------------------------------------------"
							+ getOperatingSystem()+ "  is yours Operating System" );
			log.debug(
					"------------------------------------------------------------------------------------------------------------------------------");
			//

			if (!getOperatingSystem().startsWith("Windows")) {// unix
				filPath = _FILE_PATH_UNIX;
				archivePath = ARCHIVE_PATH_UNIX;
			} else {// window
				filPath = _FILE_PATH_WINDOW;
				archivePath = ARCHIVE_PATH_WINDOW;
			}

			// Create a URL for the desired page
			URL url = new URL(_URL);
			readContent(url, filPath);
			log.debug("Create MF File completed ....");
			//
			String fileName = listFilesForFolder(new File(filPath));//// File.separator
			log.debug("read all File completed ...." + fileName);
			//
			String fulfilepath = _FILE_PATH_WINDOW + fileName;
			log.debug("---------------------" + fileName + "---------------------");
			log.debug("read all fulfilepath ...." + fulfilepath);
			//
			readFile(fulfilepath);
			//
			File sourceFile = new File(filPath + fileName);
			File sourceDir = new File(filPath);

			File destinationDir = new File(archivePath);
			//
			arciveAndMoveFile(sourceFile, sourceDir, destinationDir);
			//
			log.debug("sourceFile ...." + sourceFile);
			log.debug("destinationDir ...." + destinationDir);
			log.debug("arciveAndMoveFile File completed ....");
			//
			long endTime = System.nanoTime();
			long duration = (endTime - startTime); // divide by 1000000 to get
													// milliseconds.
			// System.out.println("End---------------------------"+duration);
			log.debug("------------------------------------------Total time taken in process=" + duration);
			//
			log.debug(
					"------------------------------------------------------------------------------------------------------------------------------");
			log.debug(
					"-----------------------------------FileUtil.initiateMutualFundNavETL End----------------------------------------------------");
			log.debug(
					"------------------------------------------------------------------------------------------------------------------------------");

		} catch (Exception exception) {
			exception.printStackTrace();
			log.debug("Exception message ...." + exception.getMessage());

		}

	}

	/**
	 * 
	 * @param url
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private void readContent(final URL url, final String filePath) throws MalformedURLException, IOException {

		InputStream input = url.openStream();

		try {
			writeFile(input, filePath);
			// System.out.println(IOUtils.toString(input));
		} finally {
			IOUtils.closeQuietly(input);
		}

	}

	private void arciveAndMoveFile(File sourceFile, File sourceDirectory, File destinationDir) {

		try {
			FileUtils.moveFileToDirectory(sourceFile, destinationDir, true);
			//
			FileUtils.cleanDirectory(sourceDirectory);

		} catch (IOException e) {
			//
			e.printStackTrace();
		}

		// System.out.println("moved succesfully....");
		log.debug("moved succesfully....");

	}

	/**
	 * @throws IOException
	 * 
	 */
	private void writeFile(final InputStream input, String filePah) throws IOException {
		String fileformat = new SimpleDateFormat("yyyyMMddhhmm'.txt'").format(new Date());
		OutputStream outputStream = new FileOutputStream(filePah + "\\NAV0-" + fileformat);
		try {
			// System.out.println(IOUtils.toString(input));
			IOUtils.copy(input, outputStream);
		} finally {
			outputStream.close();
			// System.out.println("finish...");
			log.debug("finish succesfully....");

		}

	}

	private void readFile(String fileName) {

		List<String> dataList = new ArrayList<String>();
		//
		// System.out.println("Reading File from Java code");
		log.debug("Reading File from Java code");

		// Name of the file

		try {

			// Create object of FileReader
			FileReader inputFile = new FileReader(fileName);

			// Instantiate the BufferedReader Class
			BufferedReader bufferReader = new BufferedReader(inputFile);

			// Variable to hold the one line data
			String line;
			int curLineNr = 1;
			int skipLines = 3;
			// Read file line by line and print on the console
			while ((line = bufferReader.readLine()) != null) {
				if (curLineNr++ <= skipLines) {
					continue;
				} else {
					dataList.add(line);
					// System.out.println(line);
				}
			}
			//
			// if date already exist then not run next methdo
			List<MutualFundNav> mfList = splitFileData(dataList);
			// if no data present for today's date then insert else ignore
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");
			Date todaysDate = new Date();
			String date = DATE_FORMAT.format(todaysDate);
			// System.out.println("date="+date);
			// log.debug("Programe run for todays date -----="+date);

			int count = mutualFundNavRepository.findByDateAndId(date); // TODO
																		// 19-Aug-2016
			//
			if (count == 0) {
				mutualFundNavRepository.save(mfList);

			} else {
				log.debug("----------------------------------------------------------------------");
				log.debug("Allready updated records for todays date=" + todaysDate + "count=" + count);
				log.debug("----------------------------------------------------------------------");
			}
			// Close the buffer reader
			bufferReader.close();
		} catch (Exception e) {
			log.debug("Error while reading file line by line:" + e.getMessage());

			e.printStackTrace();
		}

	}

	private List<MutualFundNav> splitFileData(final List<String> dataList) {
		MutualFundNav mutualFundNav = null;
		List<MutualFundNav> mutualFundNavList = new ArrayList<MutualFundNav>();

		for (String str : dataList) {
			mutualFundNav = new MutualFundNav();
			if (!str.isEmpty() && Character.isDigit(str.charAt(0))) {
				String split[] = str.split(";");
				mutualFundNav.setSchemeCode(split[0]);
				mutualFundNav.setIsinDivPayoutISINGrowth(split[1]);
				mutualFundNav.setIsinDivReinvestment(split[2]);
				mutualFundNav.setSchemeName(split[3]);
				mutualFundNav.setNetAssetValue(split[4]);
				mutualFundNav.setRepurchasePrice(split[5]);
				mutualFundNav.setSalePrice(split[6]);
				mutualFundNav.setDate(split[7]);
				//
				SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");
				Date todaysDate = new Date();
				String date = DATE_FORMAT.format(todaysDate);
				//System.out.println("date=" + date);
				mutualFundNav.setUpdatedDate(date);

				//
				// System.out.println("mutualFundNav=" + mutualFundNav);

				//
				mutualFundNavList.add(mutualFundNav);
				//
				// for (String s : split)
				// System.out.println("results=" + s);
			}
		}

		// return dto object
		return mutualFundNavList;
	}

	private String listFilesForFolder(final File folder) {
		String fileName = null;
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
				fileName = fileEntry.getName();
			} else {
				fileName = fileEntry.getName();
			}
		}
		return fileName;
	}

	private String getOperatingSystem() {
		return System.getProperty("os.name");

	}
}
