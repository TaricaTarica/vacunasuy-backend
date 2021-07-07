package beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.animation.Animation;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

import datatypes.DTEnfermedad;
import datatypes.DTStockVacuna;
import datatypes.DTVacuna;
import datatypes.DTVacunatorio;
import negocio.EnfermedadNegocioLocal;
import negocio.EnvioNegocioLocal;
import negocio.RegistroVacunaNegocioLocal;
import negocio.VacunaNegocioLocal;
import negocio.VacunatorioNegocioLocal;


@Named("reportesSVBean")
@ViewScoped
public class ReportesStockVacunas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@EJB
	private RegistroVacunaNegocioLocal registroLocal;
	@EJB
	private VacunaNegocioLocal vacunaLocal;
	@EJB
	private EnfermedadNegocioLocal enfermedadLocal;
	@EJB
	private VacunatorioNegocioLocal vacunatorioLocal;
	@EJB
	private EnvioNegocioLocal envioLocal;
	
	private int anio;
	
	private List<DTVacunatorio> listaVacunatorio;
	private List<String> nombreVacunatorio;
	private String vacunatorio;
	
	private List<DTStockVacuna> listaStock;
	
	private Boolean visible;
	
    private LineChartModel lineModel;
	private PieChartModel pieModel;
	private BarChartModel barModel;
	
	public ReportesStockVacunas() {
		// TODO Auto-generated constructor stub
	}

    @PostConstruct
    public void init() {
    	this.listaVacunatorio = vacunatorioLocal.listarVacunatorio();
		this.nombreVacunatorio = vacunatorioLocal.nombresVacunatorios();
		this.listaStock = envioLocal.stockEnviado(1001, LocalDate.now().getYear());
		/*for (DTVacunatorio vacunatorio: listaVacunatorio) {
			*List<DTStockVacuna >listaStockaux = envioLocal.stockEnviado(vacunatorio.getId(), LocalDate.now().getYear());
			
			 * for (DTStockVacuna stock: listaStockaux) { if
			 * (listaStock.contains(stock.getVacunaId())) {
			 * listaStock.set(listaStock.lastIndexOf(stock.getVacunaId()), stock); } else {
			 * 
			 * } }
			 
		}*/
		for (DTStockVacuna stock: listaStock) {
			int cant = registroLocal.cantVacHastaFecha(stock.getVacunaId(), LocalDate.now());
			stock.setCant(stock.getCant() - cant);
		}
    	this.visible= false;
    }
/*
    public void createLineModel() {
        lineModel = new LineChartModel();
        ChartData data = new ChartData();
        LineChartDataSet dataSet = new LineChartDataSet();
        List<Object> values = new ArrayList<>();
        if (cantidadVacunados != null) {
            for (int cant : cantidadVacunados) {
            	values.add(cant);
            }
        } else {
        	values.add(0);
        }
        dataSet.setData(values);
        dataSet.setFill(false);
        if (vacuna != null) {
        	dataSet.setLabel(vacuna.getNombre());
        } else {
        	dataSet.setLabel("");
        }
        dataSet.setBorderColor("rgb(75, 192, 192)");
        dataSet.setLineTension(0.1);
        data.addChartDataSet(dataSet);

        List<String> labels = new ArrayList<>();
        labels.add("Enero");
        labels.add("Febrero");
        labels.add("Marzo");
        labels.add("Abril");
        labels.add("Mayo");
        labels.add("Junio");
        labels.add("Julio");
        labels.add("Agosto");
        labels.add("Septiembre");
        labels.add("Octubre");
        labels.add("Noviembre");
        labels.add("Diciembre");
        data.setLabels(labels);

        //Options
        LineChartOptions options = new LineChartOptions();
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Vacunados");
        options.setTitle(title);

        lineModel.setOptions(options);
        lineModel.setData(data);
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }
    
	private void createPieModel() {
        pieModel = new PieChartModel();
        ChartData data = new ChartData();
        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        if (cantidadVacunadosPorSexo != null) {
            for (Integer cantPorSexo: cantidadVacunadosPorSexo) {
            	values.add(cantPorSexo);
            }
        } else {
        	values.add(0);
        }
        dataSet.setData(values);

        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(54, 162, 235)");
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Mujeres");
        labels.add("Hombres");
        data.setLabels(labels);

        pieModel.setData(data);
    }
    
    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
    
    public void createBarModel() {
        barModel = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Vacunados");

        List<Number> values = new ArrayList<>();
        if (cantidadVacunadosPorEdad != null) {
        	for (Integer cantXEdad :cantidadVacunadosPorEdad) {
        		values.add(cantXEdad);
        	}
        } else {
        	values.add(0);
        }

        barDataSet.setData(values);

        List<String> bgColor = new ArrayList<>();
        bgColor.add("rgba(255, 99, 132, 0.2)");
        bgColor.add("rgba(255, 159, 64, 0.2)");
        bgColor.add("rgba(255, 205, 86, 0.2)");
        bgColor.add("rgba(75, 192, 192, 0.2)");
        bgColor.add("rgba(54, 162, 235, 0.2)");
        bgColor.add("rgba(153, 102, 255, 0.2)");
        bgColor.add("rgba(201, 203, 207, 0.2)");
        barDataSet.setBackgroundColor(bgColor);

        List<String> borderColor = new ArrayList<>();
        borderColor.add("rgb(255, 99, 132)");
        borderColor.add("rgb(255, 159, 64)");
        borderColor.add("rgb(255, 205, 86)");
        borderColor.add("rgb(75, 192, 192)");
        borderColor.add("rgb(54, 162, 235)");
        borderColor.add("rgb(153, 102, 255)");
        borderColor.add("rgb(201, 203, 207)");
        barDataSet.setBorderColor(borderColor);
        barDataSet.setBorderWidth(1);

        data.addChartDataSet(barDataSet);

        List<String> labels = new ArrayList<>();
        labels.add("0 - 11");
        labels.add("12 - 17");
        labels.add("18 - 25");
        labels.add("26 - 40");
        labels.add("41 - 60");
        labels.add("61 - 75");
        labels.add("Mayores de 76");
        data.setLabels(labels);
        barModel.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        Title title = new Title();
        title.setDisplay(true);
        title.setText("Por rango de edades");
        options.setTitle(title);

        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("top");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("bold");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(24);
        legend.setLabels(legendLabels);
        options.setLegend(legend);

        // disable animation
        Animation animation = new Animation();
        animation.setDuration(0);
        options.setAnimation(animation);

        barModel.setOptions(options);
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
    
	
	public Boolean getVisible() {
		return visible;
	}

	*/

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public List<DTVacunatorio> getListaVacunatorio() {
		return listaVacunatorio;
	}

	public void setListaVacunatorio(List<DTVacunatorio> listaVacunatorio) {
		this.listaVacunatorio = listaVacunatorio;
	}

	public List<String> getNombreVacunatorio() {
		return nombreVacunatorio;
	}

	public void setNombreVacunatorio(List<String> nombreVacunatorio) {
		this.nombreVacunatorio = nombreVacunatorio;
	}

	public String getVacunatorio() {
		return vacunatorio;
	}

	public void setVacunatorio(String vacunatorio) {
		this.vacunatorio = vacunatorio;
	}

	public List<DTStockVacuna> getListaStock() {
		return listaStock;
	}

	public void setListaStock(List<DTStockVacuna> listaStock) {
		this.listaStock = listaStock;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	
	public void obtenerStock() {
		
	}
    
}	

