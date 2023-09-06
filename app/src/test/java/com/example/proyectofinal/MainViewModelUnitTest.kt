import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.proyectofinal.view.MainViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        viewModel = MainViewModel()
    }

    @Test
    fun mainViewModel_TestCompareWords() {
        // Prueba la función compareWords del ViewModel
        val result = viewModel.compareWorlds("test", "test")

        // Verifica que el resultado sea verdadero ya que las palabras son iguales
        assertEquals(true, result)
    }
}
