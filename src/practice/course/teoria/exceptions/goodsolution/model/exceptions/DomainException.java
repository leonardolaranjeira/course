package practice.course.teoria.exceptions.goodsolution.model.exceptions;

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DomainException(String msg) {
		super(msg);
	}
}
