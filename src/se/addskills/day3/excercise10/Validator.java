package se.addskills.day3.excercise10;

import java.lang.reflect.Field;

/**
 * Class to validate Object if @Validate annotation is present.
 *
 * @author Tim Mickelson
 * @since 03/06/2015
 */
public final class Validator {
	/**
	 * Not possible to instantiate an instance of Validator.
	 */
	private Validator() {};

	/**
	 * Public function validating the Object fields with @Validate annotation.
	 *  The function could be improved not taking for granted that the field is numeric when checking numeric values.
	 *
	 * @author Tim Mickelson
	 * @since 03/06/2015
	 * @param object
	 * @return true if field is valid for all present predicates.
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 */
	public static boolean validate(Object object) throws SecurityException, ClassNotFoundException {
		Field[] fields = Class.forName(object.getClass().getName()).getDeclaredFields();
		boolean isValid = true;

		// Loop Object fields and if present the @Validate annotation then validate with isValid() function.
		for (Field field:fields) {
			try {
				if (field.isAnnotationPresent(Validate.class)) {
					isValid = isValid && isValid(field, object);
				} 
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}  // end loop fields
		return isValid;
	}  // end function validate

	/**
	 * For given field validate from @Validate annotation params.
	 *
	 *
	 * @author Tim Mickelson
	 * @since 03/06/2015
	 * @param field Object field
	 * @param object The object instance to extract field data from.
	 * @return false if not all fields are valid
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private static boolean isValid(Field field, Object object) throws IllegalArgumentException, IllegalAccessException {
		boolean result = true;
		// Make field accessible even though it is private
		field.setAccessible(true);
		// Extract all predicates and validate them one by one.
		Predicates[] predicates = field.getAnnotation(Validate.class).value();
		//COMMENT: You could set throw when wrong validate used
		for (Predicates pred:predicates) {
			switch(pred) {
				case NOTNULL: {
					Object value = field.get(object);
					result = result && (value != null);
					break;
					}
				case NOTEMPTY: {
					String value = (String) field.get(object);
					result = result && (value.length() > 0);
					break;
				}
				case NOTNEGATIVE: {
					int value = (Integer) field.get(object);
					result = result &&(value >= 0);
					break;
				}
				case NOTZERO: {
					int value = (Integer) field.get(object);
					result = result && (value != 0);
				}
			}  // end switch pred
		}  // end loop predicates
		return result;
	}  // end function isValid

}  // end class Validator