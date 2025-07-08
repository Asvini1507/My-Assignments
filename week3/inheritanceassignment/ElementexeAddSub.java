package week3.inheritanceassignment;

public class ElementexeAddSub extends ButtonSub
{
	public static void main(String[] args) 
	{
        ButtonSub button = new ButtonSub();
        button.click();
        button.submit();

        TextfieldSub textField = new TextfieldSub();
        textField.setText("java");
        textField.click();
        System.out.println(textField.getText());

        CheckboxbuttonAddSub checkBox = new CheckboxbuttonAddSub();
        checkBox.click();
        checkBox.clickCheckButton();
        checkBox.submit();

        RadiobuttonAddSub radio = new RadiobuttonAddSub();
        radio.click();
        radio.selectRadioButton();
        radio.submit();
        radio.setText("hello");
      
        ElementexeAddSub elements = new ElementexeAddSub();
        elements.click();
        elements.submit();
    }
	}


