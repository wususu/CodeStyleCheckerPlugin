package checker;

import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes("checker.Checker")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CheckerProcessor  extends AbstractProcessor{

	protected NameChecker nrChecker = NameChecker.newInstance();
	
	protected Messager messager; 
	
	
	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		// TODO Auto-generated method stub
		super.init(processingEnv);
		this.messager = processingEnv.getMessager();
	}
	
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		// TODO Auto-generated method stub
		Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Checker.class);
		for (Element element : elements) {
			nrChecker.check(element);
		}
		
		List<WarnMsg> warnMsgs = nrChecker.getWarnMsgs();
		for (WarnMsg warnMsg : warnMsgs) {
			note(warnMsg);
		}
		return false;
	}
	
	protected void note(WarnMsg warnMsg){
		messager.printMessage(Diagnostic.Kind.NOTE, warnMsg.getMsg(), warnMsg.getElement());
	}

}
