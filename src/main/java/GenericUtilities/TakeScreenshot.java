package GenericUtilities;

import java.io.File;

import org.openqa.selenium.OutputType;

public interface TakeScreenshot {

	File getScreenshot(OutputType<File> file);

}
