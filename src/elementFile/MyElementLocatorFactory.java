package elementFile;

import java.lang.reflect.Field;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class MyElementLocatorFactory implements ElementLocatorFactory {

	private SearchContext searchContext;

	public MyElementLocatorFactory(SearchContext searchContext) {
		super();
		this.searchContext = searchContext;
	}

	@Override
	public ElementLocator createLocator(Field field) {
		return new DefaultElementLocator(searchContext, new MyAnnotation(field));
	}

}
