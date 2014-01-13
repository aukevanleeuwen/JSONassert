package org.skyscreamer.jsonassert;

/**
 * Associates a custom matcher to a specific jsonpath.
 */
public final class Customization implements Customizable {
	private final String path;
	private final ValueMatcher<Object> comparator;

	public Customization(String path, ValueMatcher<Object> comparator) {
        assert path != null;
        assert comparator != null;
		this.path = path;
		this.comparator = comparator;
	}

	public static Customizable customization(String path, ValueMatcher<Object> comparator) {
		return new Customization(path, comparator);
	}

    /* (non-Javadoc)
	 * @see org.skyscreamer.jsonassert.Customizable#appliesToPath(java.lang.String)
	 */
    @Override
	public boolean appliesToPath(String path) {
        return this.path.equals(path);
    }

    /* (non-Javadoc)
	 * @see org.skyscreamer.jsonassert.Customizable#matches(java.lang.Object, java.lang.Object)
	 */
    @Override
	public boolean matches(Object actual, Object expected) {
        return comparator.equal(actual, expected);
    }
}
