package checker;

import java.util.LinkedList;
import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;

import static checker.StringUtils.*;

public class NameChecker {
	
	private List<WarnMsg> warnMsgs;

	public static NameChecker newInstance(){
		return new NameChecker();
	}
	
	public NameChecker(){
		this.warnMsgs = new LinkedList<>();
	}
	
	public void check(Element element){
		List<? extends Element>elements =  element.getEnclosedElements();
		checkClass(element);
		for (Element element2 : elements) {
			if (element2.getModifiers().contains(Modifier.FINAL) && element2.getModifiers().contains(Modifier.STATIC)) {
				checkConst(element2);
				continue;
			}
			if (element2.getKind() == ElementKind.METHOD) {
				checkMethod(element2);
				continue;
			}else if (element2.getKind() == ElementKind.FIELD) {
				checkField(element2);
			}
		}
	}
	
	public void checkConst(Element element){
		if (isConstName(element.getSimpleName().toString()) == false)
			addWarnMsgs(WarnMsg.Const(element));
	}
	
	public void checkClass(Element element){
		if (isClassName(element.getSimpleName().toString()) == false)
			addWarnMsgs(WarnMsg.Class(element));
	}
	
	public void checkMethod(Element element){
		if (isMethodName(element.getSimpleName().toString()) == false)
			addWarnMsgs(WarnMsg.Method(element));
	}
	
	public void checkField(Element element){
		if (isFieldName(element.getSimpleName().toString()) == false)
			addWarnMsgs(WarnMsg.Field(element));
	}

	public List<WarnMsg> getWarnMsgs() {
		return warnMsgs;
	}
	
	protected void addWarnMsgs(WarnMsg wm){
		this.warnMsgs.add(wm);
	}
}
