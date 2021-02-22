// Assume we have the following Cars (objects)
class Car {
    String make, model, year, owner
}
def data = []
data << new Car(make: "Honda", model: "Accord", year: 2015)
data << new Car(make: "Mercedes", model: "S-Class", year: 2016, owner: "Jack")
data << new Car(make: "Nissan", model: "Altima", year: 2016, owner: "")

def writer = new StringWriter()
def xml = new groovy.xml.MarkupBuilder(writer)

// Xml declaration
xml.mkp.xmlDeclaration(version: "1.0", encoding: "utf-8")

// Start writing the xml document
xml.Inventory {
    setOmitEmptyAttributes(true)
    setOmitNullAttributes(true)
    mkp.comment "This is a comment" // Add an xml comment.

    data.each {
        def that = it
        Car(owner: that.owner) {
            Make(that.make)
            Model(that.model)
            Year(that.year)
        }
    }
}

// Write Xml to console.
println writer.toString()
