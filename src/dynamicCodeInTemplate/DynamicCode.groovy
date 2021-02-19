package dynamicCodeInTemplate

def binding = [ "date": Calendar.getInstance().getTime() ]
def f = new File('DynamicCode.template')
def engine = new groovy.text.GStringTemplateEngine()

def template = engine.createTemplate(f).make(binding)
println template.toString()
