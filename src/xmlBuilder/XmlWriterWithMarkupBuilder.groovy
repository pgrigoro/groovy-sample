package xmlBuilder

def builder = new groovy.xml.StreamingMarkupBuilder()
builder.encoding = "UTF-8"

def customer = {
    mkp.xmlDeclaration()
    customer(id:100, code:"CU-34534299"){
        firstname("Jane")
        lastname("Doe")
        phone("2105233552")
    }
}

def writer = new FileWriter("customer.xml")
writer << builder.bind(customer)




