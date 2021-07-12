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
import entidades.Vacuna;
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
	
	private LocalDate fecha;
	
	private List<DTVacunatorio> listaVacunatorio;
	private List<String> nombreVacunatorio;
	private String vacunatorio;
	private List<DTStockVacuna> listaStock;
	private Boolean visible;
	private BarChartModel barModel;
	private long idVacunatorio;
	public ReportesStockVacunas() {
		// TODO Auto-generated constructor stub
	}

    @PostConstruct
    public void init() {
    	this.listaVacunatorio = vacunatorioLocal.listarVacunatorio();
		this.nombreVacunatorio = vacunatorioLocal.nombresVacunatorios();
		this.listaStock = new ArrayList<DTStockVacuna>();
		this.fecha = LocalDate.now();
		for (DTVacunatorio vac: listaVacunatorio) {
			List<DTStockVacuna> listaStockAux = envioLocal.stockEnviado(vac.getId(), LocalDate.now());
			for (DTStockVacuna stock: listaStockAux) {
				int posicion = posicionVacuna(listaStock,stock.getVacunaId());
				if (posicion == -1) {
					this.listaStock.add(stock);
				} else {
					listaStock.get(posicion).setCant(listaStock.get(posicion).getCant() + stock.getCant());
				}
			}
		}
		for (DTStockVacuna stock: listaStock) {
			int cant = registroLocal.cantVacHastaFecha(stock.getVacunaId(), LocalDate.now());
			stock.setCant(stock.getCant() - cant);
		}
    	this.visible= false;
		this.idVacunatorio = 0;
		createBarModel();
    }
   
    int posicionVacuna(List<DTStockVacuna> list, long vacunaId) {
    	int index = 0;
		for (DTStockVacuna vac : list) {
			if (vac.getVacunaId() == vacunaId) {
				return index;
			}
			index++;
		}
		return -1;
	}

    
    public void createBarModel() {
        barModel = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Vacunas");

        List<Number> values = new ArrayList<>();
        if (listaStock != null) {
        	for (DTStockVacuna stock :listaStock) {
        		values.add(stock.getCant());
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
        if (listaStock != null) {
        	for (DTStockVacuna stock :listaStock) {
        		labels.add(stock.getNombre());
        	}
        }
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
        title.setText(vacunatorio);
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
    
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
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
	
	public long getIdVacunatorio() {
		return idVacunatorio;
	}

	public void setIdVacunatorio(long idVacunatorio) {
		this.idVacunatorio = idVacunatorio;
	}

	public void obtenerStock() {
		this.visible= true;
		for (DTVacunatorio vac: listaVacunatorio) {
			if (vac.getNombre().equals(vacunatorio)) {
				idVacunatorio = vac.getId();
			}
		}
		listaStock = envioLocal.stockEnviado(idVacunatorio, fecha);
		for (DTStockVacuna stock: listaStock) {
			int cant = registroLocal.cantVacHastaFecha(stock.getVacunaId(), fecha);
			stock.setCant(stock.getCant() - cant);
		}
		createBarModel();
		this.idVacunatorio = 0;
		this.vacunatorio = "";
	}
    
}	

