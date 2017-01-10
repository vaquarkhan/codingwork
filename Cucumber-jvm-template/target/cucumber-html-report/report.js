$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/ShoppingCart.feature");
formatter.feature({
  "line": 1,
  "name": "Shopping cart on an cna.com website",
  "description": "",
  "id": "shopping-cart-on-an-cna.com-website",
  "keyword": "Feature"
});
formatter.before({
  "duration": 18618548484,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Sign in and sign out",
  "description": "",
  "id": "shopping-cart-on-an-cna.com-website;sign-in-and-sign-out",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I open cna.com website",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "I sign in",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I sign out",
  "keyword": "Then "
});
formatter.match({
  "location": "ShoppingCart.i_open_automationpractice_website()"
});
formatter.result({
  "duration": 33353681567,
  "status": "passed"
});
formatter.match({
  "location": "ShoppingCart.i_sign_in()"
});
formatter.result({
  "duration": 258433265,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"link text\",\"selector\":\"Sign in\"}\n  (Session info: chrome\u003d51.0.2704.103)\n  (Driver info: chromedriver\u003d2.22.397933 (1cab651507b88dec79b2b2a22d1943c01833cc1b),platform\u003dWindows NT 6.1.7601 SP1 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 239 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.44.0\u0027, revision: \u002776d78cf323ce037c5f92db6c1bba601c2ac43ad8\u0027, time: \u00272014-10-23 13:11:40\u0027\nSystem info: host: \u0027LNAR-PB0313M0\u0027, ip: \u0027192.168.0.35\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027x86\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.22.397933 (1cab651507b88dec79b2b2a22d1943c01833cc1b), userDataDir\u003dC:\\Users\\viqkhan\\AppData\\Local\\Temp\\scoped_dir6840_1804}, takesHeapSnapshot\u003dtrue, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d51.0.2704.103, platform\u003dXP, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: bcf0eb6cbe396923c5b2e602e862e874\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:204)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:156)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:599)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:352)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByLinkText(RemoteWebDriver.java:401)\r\n\tat org.openqa.selenium.By$ByLinkText.findElement(By.java:242)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:344)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:59)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:37)\r\n\tat com.sun.proxy.$Proxy13.click(Unknown Source)\r\n\tat test.java.modules.SignInAction.Execute(SignInAction.java:17)\r\n\tat test.java.step_definitions.ShoppingCart.i_sign_in(ShoppingCart.java:46)\r\n\tat ✽.And I sign in(features/ShoppingCart.feature:5)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "ShoppingCart.i_sign_out()"
});
formatter.result({
  "status": "skipped"
});
formatter.write("Current Page URL is https://www.cna.com/web/guest/cna/agentcenterpublic/!ut/p/b1/04_Sj9CPykssy0xPLMnMz0vMAfGjzOJNDLy9Q3xMQo28jI1NDRz93Q1MDP28jUwCzIEKIpEVOPl5GgIV-AMJP1OD0GBD4vQb4ACOBoT0e-lHpefkJwGdGq4fhVexpSm6AiyOBSvA4xo_j_zcVP2C3NCIymBPXQBq-mkG/dl4/d5/L2dBISEvZ0FBIS9nQSEh/");
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1513730232,
  "status": "passed"
});
formatter.uri("features/seleniumframework.feature");
formatter.feature({
  "line": 1,
  "name": "Access seleniumframework.com website",
  "description": "Use selenium java with cucumber-jvm and navigate to website",
  "id": "access-seleniumframework.com-website",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4426506034,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Print title, url",
  "description": "",
  "id": "access-seleniumframework.com-website;print-title,-url",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I open seleniumframework website",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I validate title and url",
  "keyword": "Then "
});
formatter.match({
  "location": "BlankStepDefs.i_open_seleniumframework_website()"
});
formatter.result({
  "duration": 59162262824,
  "status": "passed"
});
formatter.match({
  "location": "BlankStepDefs.i_print_title_and_URL()"
});
formatter.result({
  "duration": 117198831,
  "status": "passed"
});
formatter.after({
  "duration": 1138532363,
  "status": "passed"
});
});