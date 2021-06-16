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

import datatypes.DTVacuna;
import negocio.RegistroVacunaNegocioLocal;
import negocio.VacunaNegocioLocal;


@Named("reportesACBean")
@ViewScoped
public class ReportesActosVacunalesBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@EJB
	private RegistroVacunaNegocioLocal registroLocal;
	@EJB
	private VacunaNegocioLocal vacunaLocal;
	
	private List<Integer> cantidadVacunados;
	private int anio;
	private DTVacuna vacuna;
	private List<DTVacuna> listaVacunas;
	private List<String> nombreVacunas;
	private String vac;

    private LineChartModel lineModel;
	private PieChartModel pieModel;
	private BarChartModel barModel;
	
	public ReportesActosVacunalesBean() {
		// TODO Auto-generated constructor stub
	}

    @PostConstruct
    public void init() {
        this.cantidadVacunados = new ArrayList<Integer>();
		this.listaVacunas = vacunaLocal.obtenerVacunas();
		this.nombreVacunas = vacunaLocal.nombresVacunas();
		createLineModel();
		createPieModel();
		createBarModel();
    }

    public void createLineModel() {
        lineModel = new LineChartModel();
        ChartData data = new ChartData();
        LineChartDataSet dataSet = new LineChartDataSet();
        List<Object> values = new ArrayList<>();
        if (cantidadVacunados != null) {
            for (int cant : cantidadVacunados) {
            	values.add(cant);
            }
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
        values.add(300);
        values.add(50);
        values.add(100);
        dataSet.setData(values);

        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(54, 162, 235)");
        bgColors.add("rgb(255, 205, 86)");
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Red");
        labels.add("Blue");
        labels.add("Yellow");
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
        barDataSet.setLabel("My First Dataset");

        List<Number> values = new ArrayList<>();
        values.add(65);
        values.add(59);
        values.add(80);
        values.add(81);
        values.add(56);
        values.add(55);
        values.add(40);
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
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
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
        title.setText("Bar Chart");
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
    
	public List<Integer> getCantidadVacunados() {
		return cantidadVacunados;
	}

	public void setCantidadVacunados(List<Integer> cantidadVacunados) {
		this.cantidadVacunados = cantidadVacunados;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public DTVacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(DTVacuna vacuna) {
		this.vacuna = vacuna;
	}

	public List<DTVacuna> getListaVacunas() {
		return listaVacunas;
	}

	public void setListaVacunas(List<DTVacuna> listaVacunas) {
		this.listaVacunas = listaVacunas;
	}
	
	public List<String> getNombreVacunas() {
		return nombreVacunas;
	}

	public void setNombreVacunas(List<String> nombreVacunas) {
		this.nombreVacunas = nombreVacunas;
	}
	
	public String getVac() {
		return vac;
	}

	public void setVac(String vac) {
		this.vac = vac;
	}

	public void obtenerVacunadosXAnio() {
		this.vacuna = new DTVacuna();
		for (DTVacuna dtVacuna : listaVacunas) {
			if (dtVacuna.getNombre().equals(vac)) {
				this.vacuna = dtVacuna;
			}
		}
		this.cantidadVacunados = registroLocal.obtenerCantVac(vacuna, anio);
		createLineModel();
		this.vacuna = new DTVacuna();
		this.anio = 0;
	}
}	

