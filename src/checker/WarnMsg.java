package checker;


import javax.lang.model.element.Element;

/**
 * 消息实体
 * @author janke
 *
 */
public class WarnMsg {
	
	public static final String FIELD_WARN_MSG = "实例属性名不符合命名规则";
	public static final String METHOD_WARN_MSG = "方法名不符合命名规则";
	public static final String CLASS_WARN_MSG = "类名不符合命名规则";
	public static final String CONST_WARN_MSG = "常量名不符合命名规则";
	
	public static WarnMsg Field(Element element){
		return new WarnMsg(FIELD_WARN_MSG, element);
	}
	
	public static WarnMsg Method(Element element){
		return new WarnMsg(METHOD_WARN_MSG, element);
	}
	
	public static WarnMsg Class(Element element){
		return new WarnMsg(CLASS_WARN_MSG, element);
	}
	
	public static WarnMsg Const(Element element) {
		return new WarnMsg(CONST_WARN_MSG, element);
	}
	
	public WarnMsg(String msg, Element element) {
		// TODO Auto-generated constructor stub
		this.msg = msg;
		this.element = element;
	}
	
	private Element element;
	
	private String msg;

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "WarnMsg [element=" + element + ", msg=" + msg + "]";
	}
}
