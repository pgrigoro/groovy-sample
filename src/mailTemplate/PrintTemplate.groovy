package mailTemplate

Map binding = [ name: 'George', city: "Athens", month: "April", signed: "Panos"]
def f = new File('mail.template')
def engine = new groovy.text.GStringTemplateEngine()

def template = engine.createTemplate(f).make(binding)
println template.toString()

