package org.sugarlist.utils

public class PropertiesFormater {

	def show(prop) {
		def txt = prop.toString()

		def n_spaces = 0 
		def space = ' '
		def OPEN =  '['
		def CLOSE = ']'
		def COMMA = ','
		def START = '^'
		def EMPTY = ' '
		txt.each { c ->
			if(c != EMPTY) {
				if(c == OPEN) {
					println "\n${space*n_spaces}${c}"
					n_spaces++
					print "${space*(n_spaces)}"
				} else if(c == CLOSE) {			
					n_spaces--			
					print "${space*(n_spaces)}${c}"
				} else if(c == COMMA) {
					print "${c}\n${space*(n_spaces)}"
				} else {
					print "${c}"
				}		
			}
		}
		println ''		
	}
}