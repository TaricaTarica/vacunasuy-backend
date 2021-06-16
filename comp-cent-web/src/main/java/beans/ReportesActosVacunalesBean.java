package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;

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

	public ReportesActosVacunalesBean() {
		// TODO Auto-generated constructor stub
	}
    private LineChartModel lineModel;

    @PostConstruct
    public void init() {
        this.cantidadVacunados = new ArrayList<Integer>();
		vacuna = vacunaLocal.obtenerVacuna(1001);
		this.obtenerVacunadosXAnio(vacuna,2021);
		createLineModel();
    }

    public void createLineModel() {
        lineModel = new LineChartModel();
        ChartData data = new ChartData();
        LineChartDataSet dataSet = new LineChartDataSet();
        List<Object> values = new ArrayList<>();
        for (int cant : cantidadVacunados) {
        	values.add(cant);
        }
        dataSet.setData(values);
        dataSet.setFill(false);
        dataSet.setLabel(vacuna.getNombre());
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

	public void obtenerVacunadosXAnio(DTVacuna vacuna, int anio) {
		this.cantidadVacunados = registroLocal.obtenerCantVac(vacuna, anio);
	}
}	

