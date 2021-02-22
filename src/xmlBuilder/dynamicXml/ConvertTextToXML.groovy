package xmlBuilder.dynamicXml

import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil

Date date = new Date()
def datePart = date.format("dd/MM/yyyy")
def timePart = date.format("HH:mm:ss")

def lines = new File('products.txt').readLines()
def builder = new StreamingMarkupBuilder()
builder.encoding = 'UTF-8'

def xml = builder.bind {
    mkp.xmlDeclaration()

    products {
        day (datePart)
        time(timePart)
        lines.each { line ->
            def data = line.split(',')*.trim()
            product {
                name (data[0])
                price (data[1])
                description (data[2])
            }
        }
    }
}

def updatedXml = XmlUtil.serialize(xml)

// Save the output to a file
new File('products.xml').write(updatedXml)
println updatedXml

