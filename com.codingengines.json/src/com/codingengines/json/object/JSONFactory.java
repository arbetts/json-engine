package com.codingengines.json.object;

/**
 * Created by Andrew on 2/18/2018.
 */
public class JSONFactory {

	/*
2.  JSON Grammar

   A JSON text is a sequence of tokens.  The set of tokens includes six
   structural characters, strings, numbers, and three literal names.

   A JSON text is a serialized object or array.

      JSON-text = object / array

   These are the six structural characters:

      begin-array     = ws %x5B ws  ; [ left square bracket

      begin-object    = ws %x7B ws  ; { left curly bracket

      end-array       = ws %x5D ws  ; ] right square bracket

      end-object      = ws %x7D ws  ; } right curly bracket

      name-separator  = ws %x3A ws  ; : colon

      value-separator = ws %x2C ws  ; , comma

   Insignificant whitespace is allowed before or after any of the six
   structural characters.

      ws = *(
                %x20 /              ; Space
                %x09 /              ; Horizontal tab
                %x0A /              ; Line feed or New line
                %x0D                ; Carriage return
            )

2.1.  Values

   A JSON value MUST be an object, array, number, or string, or one of
   the following three literal names:

      false null true

   The literal names MUST be lowercase.  No other literal names are
   allowed.

         value = false / null / true / object / array / number / string

         false = %x66.61.6c.73.65   ; false

         null  = %x6e.75.6c.6c      ; null

         true  = %x74.72.75.65      ; true

2.2.  Objects

   An object structure is represented as a pair of curly brackets
   surrounding zero or more name/value pairs (or members).  A name is a
   string.  A single colon comes after each name, separating the name
   from the value.  A single comma separates a value from a following
   name.  The names within an object SHOULD be unique.

      object = begin-object [ member *( value-separator member ) ]
      end-object

      member = string name-separator value

2.3.  Arrays

   An array structure is represented as square brackets surrounding zero
   or more values (or elements).  Elements are separated by commas.

      array = begin-array [ value *( value-separator value ) ] end-array

2.4.  Numbers

   The representation of numbers is similar to that used in most
   programming languages.  A number contains an integer component that
   may be prefixed with an optional minus sign, which may be followed by
   a fraction part and/or an exponent part.

   Octal and hex forms are not allowed.  Leading zeros are not allowed.

   A fraction part is a decimal point followed by one or more digits.

   An exponent part begins with the letter E in upper or lowercase,
   which may be followed by a plus or minus sign.  The E and optional
   sign are followed by one or more digits.

   Numeric values that cannot be represented as sequences of digits
   (such as Infinity and NaN) are not permitted.

         number = [ minus ] int [ frac ] [ exp ]

         decimal-point = %x2E       ; .

         digit1-9 = %x31-39         ; 1-9

         e = %x65 / %x45            ; e E

         exp = e [ minus / plus ] 1*DIGIT

         frac = decimal-point 1*DIGIT

         int = zero / ( digit1-9 *DIGIT )

         minus = %x2D               ; -

         plus = %x2B                ; +

         zero = %x30                ; 0

2.5.  Strings

   The representation of strings is similar to conventions used in the C
   family of programming languages.  A string begins and ends with
   quotation marks.  All Unicode characters may be placed within the
   quotation marks except for the characters that must be escaped:
   quotation mark, reverse solidus, and the control characters (U+0000
   through U+001F).

   Any character may be escaped.  If the character is in the Basic
   Multilingual Plane (U+0000 through U+FFFF), then it may be
   represented as a six-character sequence: a reverse solidus, followed
   by the lowercase letter u, followed by four hexadecimal digits that
   encode the character's code point.  The hexadecimal letters A though
   F can be upper or lowercase.  So, for example, a string containing
   only a single reverse solidus character may be represented as
   "\u005C".

   Alternatively, there are two-character sequence escape
   representations of some popular characters.  So, for example, a
   string containing only a single reverse solidus character may be
   represented more compactly as "\\".

   To escape an extended character that is not in the Basic Multilingual
   Plane, the character is represented as a twelve-character sequence,
   encoding the UTF-16 surrogate pair.  So, for example, a string
   containing only the G clef character (U+1D11E) may be represented as
   "\uD834\uDD1E".

         string = quotation-mark *char quotation-mark

         char = unescaped /
                escape (
                    %x22 /          ; "    quotation mark  U+0022
                    %x5C /          ; \    reverse solidus U+005C
                    %x2F /          ; /    solidus         U+002F
                    %x62 /          ; b    backspace       U+0008
                    %x66 /          ; f    form feed       U+000C
                    %x6E /          ; n    line feed       U+000A
                    %x72 /          ; r    carriage return U+000D
                    %x74 /          ; t    tab             U+0009
                    %x75 4HEXDIG )  ; uXXXX                U+XXXX

         escape = %x5C              ; \

         quotation-mark = %x22      ; "

         unescaped = %x20-21 / %x23-5B / %x5D-10FFFF

3.  Encoding

   JSON text SHALL be encoded in Unicode.  The default encoding is
   UTF-8.

   Since the first two characters of a JSON text will always be ASCII
   characters [RFC0020], it is possible to determine whether an octet
   stream is UTF-8, UTF-16 (BE or LE), or UTF-32 (BE or LE) by looking
   at the pattern of nulls in the first four octets.

           00 00 00 xx  UTF-32BE
           00 xx 00 xx  UTF-16BE
           xx 00 00 00  UTF-32LE
           xx 00 xx 00  UTF-16LE
           xx xx xx xx  UTF-8

4.  Parsers

   A JSON parser transforms a JSON text into another representation.  A
   JSON parser MUST accept all texts that conform to the JSON grammar.
   A JSON parser MAY accept non-JSON forms or extensions.

   An implementation may set limits on the size of texts that it
   accepts.  An implementation may set limits on the maximum depth of
   nesting.  An implementation may set limits on the range of numbers.
   An implementation may set limits on the length and character contents
   of strings.

5. Generators

   A JSON generator produces JSON text.  The resulting text MUST
   strictly conform to the JSON grammar.

6. IANA Considerations

   The MIME media type for JSON text is application/json.

   Type name: application

   Subtype name: json

   Required parameters: n/a

   Optional parameters: n/a

   Encoding considerations: 8bit if UTF-8; binary if UTF-16 or UTF-32

      JSON may be represented using UTF-8, UTF-16, or UTF-32.  When JSON
      is written in UTF-8, JSON is 8bit compatible.  When JSON is
      written in UTF-16 or UTF-32, the binary content-transfer-encoding
      must be used.

   Security considerations:

   Generally there are security issues with scripting languages.  JSON
   is a subset of JavaScript, but it is a safe subset that excludes
   assignment and invocation.

   A JSON text can be safely passed into JavaScript's eval() function
   (which compiles and executes a string) if all the characters not
   enclosed in strings are in the set of characters that form JSON
   tokens.  This can be quickly determined in JavaScript with two
   regular expressions and calls to the test and replace methods.

      var my_JSON_object = !(/[^,:{}\[\]0-9.\-+Eaeflnr-u \n\r\t]/.test(
             text.replace(/"(\\.|[^"\\])*"/g, ''))) &&
         eval('(' + text + ')');

   Interoperability considerations: n/a

   Published specification: RFC 4627
	 */

	public static JSONArray createJSONArray() {
		return new JSONArray();
	}

	public static JSONArray createJSONArray(String json) {
		//TODO parse string into json array

		return new JSONArray();
	}

	public static JSONObject createJSONObject() {
		return new JSONObject();
	}

	public static JSONObject createJSONObject(String json) {
		//TODO parse string into json object

		return new JSONObject();
	}

}