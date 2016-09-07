# proxymusic

ProxyMusic allows to marshal/unmarshal Java objects in memory to/from MusicXML 3.0
data in a Document, a stream or a file.

This binding provides an easy way for Java programs dealing with music symbolic
information (such as score scanners, music editors, music sequencers, etc) to read
or write files in MusicXML.

ProxyMusic supports the following MusicXML features:

* Marshalling/unmarshalling of ScorePartwise
* Marshalling/unmarshalling of Opus
* Handling of standard (uncompressed) .xml files
* Handling of compressed .mxl files

# Implementation

All MusicXML elements and attributes are implemented as 250+ Java classes that are
automatically generated from the MusicXML defining shema as found on [its vendor site.](http://www.musicxml.com/for-developers/)

The main advantage of this automated approach is to result in an efficient and error-free implementation.

# Building

Building ProxyMusic is easily achieved with the following terminal command:

```mvn clean install```

This command will (re)build the ProxyMusic Maven artifacts (binary, source and doc),
taking as input the schema definition files ```src/main/xsd/musicxml.xsd``` and ```src/main/xsd/opus.xsd```.

# Usage

The ProxyMusic binding is made available for any Java application as a dedicated jar file.

A utility class, named proxymusic.util.Marshalling, is available to ease the handling
of both marshalling and unmarshalling of ScorePartwise and Opus entities.`

A few examples of use:

* A small example is available in the proxymusic.util package in the test branch, its name is ```proxymusic.util.HelloWorldTest.java```. This example performs marshalling and unmarshalling of the classical HelloWorld as available in the MusicXML tutorial.
* Another small example, focused on the marshalling and the unmarshalling of a part-list element, is available as ```proxymusic.util.ScorePartTest.java```.
* For marshalling and unmarshalling Opus entities, see simple ```proxymusic.opus.OpusTest.java``` example or more realistic ```proxymusic.opus.MxlOpusTest.java``` example.
* For dealing with compressed .mxl files, see ```proxymusic.mxl.MxlTest.java``` example or ```proxymusic.opus.MxlOpusTest.java```.
* A real size example is provided by the companion [Audiveris project](https://github.com/Audiveris/audiveris-v5). Audiveris is an Optical Music Recognition software (OMR) which uses ProxyMusic to handle the marshalling layer. For detailed information, refer to Audiveris BookExporter Java class.