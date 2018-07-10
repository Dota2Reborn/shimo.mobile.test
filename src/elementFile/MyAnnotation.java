package elementFile;

import java.lang.reflect.Field;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.Annotations;

public class MyAnnotation extends Annotations {

	public MyAnnotation(Field field) {
		super(field);
	}

	@Override
	public By buildBy() {
		By by = null;
		SearchWith searchWith = super.getField().getAnnotation(SearchWith.class);

		if (null != searchWith) {
			by = ByGenerator.createBy(searchWith.pageName(), searchWith.elementName(), searchWith.noteName());
		}
		// System.out.println("By INFO: " + (null == by));
		return by;
	}

}
