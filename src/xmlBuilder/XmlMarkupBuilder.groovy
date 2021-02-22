package xmlBuilder

def strWriter = new StringWriter()
def xml = new groovy.xml.MarkupBuilder(strWriter)
xml.mkp.xmlDeclaration version: "1.0", encoding: "utf-8"

xml.kml(xmlns: "http://www.opengis.net/kml/2.2") {
    Documents {
        Placemark() {
            name "New York"
            description "New York City"
            pont {
                coordinates "- 74.006393, 40.714172, 0"
            }
        }
    }
}

println strWriter.toString()
