In this project I have used Android Studio to generate virtual mobile device and in order to run written code I have used 
Appium Server.I have utilized from  Appium Inspector in order to be able to locate elements.
And finally I have navigated appium with Java-client by using IntelliJ IDE.In this appium project I have implemented Singleton Design Pattern and Page Object Model Design Pattern.
Singleton Design Pattern is used to have same driver instance where ever and whenever we need to call driver.
It helps us to run our scripts or test cases with only and same driver.By doing this, we prevent some connection and execution
problem that might be occured.

Page Object Model Design Pattern is used to have more structural and maintainable framework.Basically we create 
different class pages for every single application page and store all the relevant locator, web elements and also some useful
methods that we need to use for the execution into this page and use these features in the test class by creating an object.
It allows us to manage our framework more easily.

In this basic test execution I created also properties file to avoid hard coding.I provide some kind of important test data inside 
of this properties file with key-value format and whenever I need it, I call the data from this properties file.In order to call the data I created configurationReader file under my utils package.
It allows us to control our data and when we need to do some changes , we can directly change the data by using properties file.

I would like mention something which is that most of the elements in application has no accessibility ID which is very useful to locate web elements.Because of this I have preferred
to use xpath with text.There was not any other option.And I had to use thread.sleep method time to time because the app is working very slow just because probably my internet speed and computer set up.Normally it s not recommended
to use sleep method.In my current project I generally use explicit wait for my selenium project but in appium project there is no this kind of feature like explicit wait. 
