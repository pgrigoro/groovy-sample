package xmlParsing

import groovy.xml.DOMBuilder;
import groovy.xml.dom.DOMCategory;

// Convert the input XML file content to a string
def input = new File('in.xml').text

// Parse the input string using DOMBuilder
def doc = DOMBuilder.parse(new StringReader(input))

// Access the root element, which is meals
def meals = doc.documentElement

// Use DOMCategory to update values
use(DOMCategory) {
    // Get the breakfast category
    def category = meals.category[0]
    if (category.properties.get("type") == "breakfast") {
        category['@time'] = '7am'
    }
}

// Save the output to a file
new File('out.xml').write(meals as String)