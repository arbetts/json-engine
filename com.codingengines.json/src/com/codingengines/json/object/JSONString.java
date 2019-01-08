package com.codingengines.json.object;

/**
 * Created by Andrew on 2/18/2018.
 *
 * also handles null
 */
public final class JSONString extends BaseJSONPrimitive<String> {

	JSONString(String s, JSONElement<?> parent) {
		super(s, parent);
	}

	public String toJSON() {
		if (p == null) {
			return "null";
		}

		return super.toJSON();
	}

	protected void toJSON(StringBuilder sb) {
		if (p == null) {
			sb.append("null");

			return;
		}

		char c;
		char r;
		int len = p.length();
		String hexString;

		for (int i = 0; i < len; i++) {
			c = p.charAt(i);

			switch (c) {
				case '"':
				case '\b':
				case '\t':
				case '\n':
				case '\f':
				case '\r':
					r = getReplaceChar(c);

					if ((i > 0) && (p.charAt(i - 1) != '\\')) {
						sb.append('\\');
						sb.append(r);
					}
					else {
						sb.append(c);
					}

					break;

				case '\\':
					if (c == len -1) {
						r = c;

						int count = 0;

						while (r == '\\') {
							r = p.charAt(i - ++count);
						}

						if (count % 2 != 0) {
							sb.append('\\');
						}
					}
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
		if (p == null) {
			return null;
		}

		return '\"';
	}

	@Override
	protected Character closeChar() {
		if (p == null) {
			return null;
		}

		return '\"';
	}

	private char getReplaceChar(char c) {
		switch (c) {
			case '\b':
				return 'b';
			case '\t':
				return 't';
			case '\n':
				return 'n';
			case '\f':
				return 'f';
			case '\r':
				return 'r';
			default:
				return c;
		}
	}
}