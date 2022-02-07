# ProxyMusic

ProxyMusic allows to marshal/unmarshal Java objects in memory to/from MusicXML 4.0
data in a Document, a stream or a file.

This binding provides an easy way for Java programs dealing with music symbolic
information (such as score scanners, music editors, music sequencers, etc) to read
or write files in MusicXML.

ProxyMusic supports the following MusicXML features:

* Marshalling/unmarshalling of **ScorePartwise**
* Marshalling/unmarshalling of **Opus**
* Handling of standard (uncompressed) `.xml` files
* Handling of compressed `.mxl` files

## Implementation

All MusicXML elements and attributes are implemented as about 325 Java classes that are
automatically generated from the MusicXML defining schema as found on
[its vendor site][musicxml-developers].

The main advantage of this automated approach is to result in an efficient and error-free implementation.

## Building


Building ProxyMusic is easily achieved with the following terminal command:

```
$> mvn clean package
```

This command will (re)build the ProxyMusic Maven artifacts (binary, source and doc),
taking as input the schema definition files `src/main/xsd/musicxml.xsd` and `src/main/xsd/opus.xsd`.

## Usage

The latest ProxyMusic release is available on [Maven Central][maven-central-proxymusic]
and thus can be easily integrated in a Gradle or Maven build.
Alternatively, it is possible to [build a local artifact](#building).

A utility Java class, named `proxymusic.util.Marshalling`, is available to ease the handling
of both marshalling and unmarshalling of *ScorePartwise* and *Opus* entities.

A few examples of use:

* A small example is available in the `proxymusic.util` package located in the test branch,
  its name is `proxymusic.util.HelloWorldTest.java`.   
  This example performs marshalling and unmarshalling of the classical HelloWorld as available in
  the MusicXML tutorial.
* Another small example, focused on the marshalling and the unmarshalling of a part-list element,
  is available as `proxymusic.util.ScorePartTest.java`.
* For marshalling and unmarshalling Opus entities, see `proxymusic.opus.OpusTest.java` simple
  example or `proxymusic.opus.MxlOpusTest.java` more realistic example.
* For dealing with compressed `.mxl` files, see `proxymusic.mxl.MxlTest.java`
  or `proxymusic.opus.MxlOpusTest.java` examples.
* A real size example is provided by the companion [Audiveris project][audiveris-project].   
  Audiveris is an Optical Music Recognition software (OMR) which uses ProxyMusic to handle
  the marshalling layer.   
  For detailed information, refer to Audiveris [ScoreExporter][score-exporter]
  and  [PartwiseBuilder][partwise-builder] Java classes.

---
[musicxml-developers]:      http://www.musicxml.com/for-developers/
[maven-central-proxymusic]: https://mvnrepository.com/artifact/org.audiveris/proxymusic/4.0.1
[audiveris-project]:        https://github.com/Audiveris/audiveris
[score-exporter]:           https://github.com/Audiveris/audiveris/blob/master/src/main/org/audiveris/omr/score/ScoreExporter.java
[partwise-builder]:         https://github.com/Audiveris/audiveris/blob/master/src/main/org/audiveris/omr/score/PartwiseBuilder.java
