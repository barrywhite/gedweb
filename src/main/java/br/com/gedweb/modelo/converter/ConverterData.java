package br.com.gedweb.modelo.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("br.com.modeloArquitetura.modelo.converter.converterData")
public class ConverterData implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		
		SimpleDateFormat formatatorData = new SimpleDateFormat("dd/mm/yyyy");
		return formatatorData.format(new Date(value));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		
		return value.toString();
	}

}
