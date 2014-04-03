package security;

public class Cookie {
	private String _key;
	private String _value;
	
	public Cookie(String _key, String _value) {
		this._key = _key;
		this._value = _value;
	}
	
	public String get_key() {
		return _key;
	}
	
	public String get_value() {
		return _value;
	}
}
