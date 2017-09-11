# numbers-in-english
Takes an integer value, outputs its representation in English

Sample input | Sample output
------------ | -------------
0 | Zero
13 | Thirteen
85 | Eighty five
5237 | Five thousand two hundred and thirty seven

### Dependencies:

* Java 8
* Ant
* JUnit and Hamcrest (jars should be in your Ant or Java classpath)

### To build:

```ant compile```

### To run tests:

```ant test```

### To run the code, i.e. convert an integer X to English:

```ant -Dinput=X```
