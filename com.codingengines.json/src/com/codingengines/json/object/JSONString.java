package com.codingengines.json.object;

/**
 * Created by Andrew on 2/18/2018.
 */
public final class JSONString extends BaseJSONPrimitive<String> {

	JSONString(String s, JSONElement<?> parent) {
		super(s, parent);
	}

	protected void toJSON(StringBuilder sb) {
		char c;
		int len = _p.length();
		String hexString;

		for (int i = 0; i < len; i += 1) {
			c = _p.charAt(i);

			switch (c) {
				case '\\':
				case '/':
				case '"':
					sb.append('\\');
					sb.append(c);
					break;

				case '\b':
					sb.append("\\b");
					break;
				case '\t':
					sb.append("\\t");
					break;
				case '\n':
					sb.append("\\n");
					break;
				case '\f':
					sb.append("\\f");
					break;
				case '\r':
					sb.append("\\r");
					break;

				default:
					if (c < ' ') {
						hexString = Integer.toHexString(c);

						sb.append("\\u");

						switch (hexString.length()) {
							case 1:
								sb.append('0');
							case 2:
								sb.append('0');
							case 3:
								sb.append('0');
							case 4:
								sb.append(hexString);
						}
					}
					else {
						sb.append(c);
					}
			}
		}
	}

	@Override
	protected Character openChar() {
		return '\"';
	}

	@Override
	protected Character closeChar() {
		return '\"';
	}

}