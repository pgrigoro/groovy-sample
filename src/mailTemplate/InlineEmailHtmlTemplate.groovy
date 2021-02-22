package mailTemplate

import groovy.text.markup.MarkupTemplateEngine

def emailHtmlTemplate = """
html {
    head {
        title('Service Subscription Email')
    }
    body {
        p('Dear Norman')
        p('Thanks for subscribing our services.')
    }
}"""

def emailHtml = new MarkupTemplateEngine().createTemplate(emailHtmlTemplate).make()
println emailHtml.toString()