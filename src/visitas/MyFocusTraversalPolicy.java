package visitas;
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;

class MyFocusTraversalPolicy extends FocusTraversalPolicy{
	
	  public Component getComponentAfter(Container focusCycleRoot,Component aComponent)  {
		  MarineMassPro.focusNumber = (MarineMassPro.focusNumber+1) % MarineMassPro.focusList.length;
		  return (Component) MarineMassPro.focusList[MarineMassPro.focusNumber];
	  }
	  
	  public Component getComponentBefore(Container focusCycleRoot,Component aComponent){
		  MarineMassPro.focusNumber = (MarineMassPro.focusList.length+MarineMassPro.focusNumber-1) % MarineMassPro.focusList.length;
		  return (Component)MarineMassPro.focusList[MarineMassPro.focusNumber];
	  }
	  
	  public Component getDefaultComponent(Container focusCycleRoot){return (Component)MarineMassPro.focusList[0];}
	  public Component getLastComponent(Container focusCycleRoot){return (Component)MarineMassPro.focusList[MarineMassPro.focusList.length-1];}
	  public Component getFirstComponent(Container focusCycleRoot){return (Component)MarineMassPro.focusList[2];}
	  
}