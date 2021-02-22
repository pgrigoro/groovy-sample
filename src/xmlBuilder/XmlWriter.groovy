package xmlBuilder

def sw = new StringWriter()
def xml = new groovy.xml.MarkupBuilder(sw)
xml.langs(type:"current", count:2, mainstream:true){
    language(type:"static", version:"11", "Java")
    language(type:"dynamic", version:"3.0.7", "Groovy")
}
println sw



