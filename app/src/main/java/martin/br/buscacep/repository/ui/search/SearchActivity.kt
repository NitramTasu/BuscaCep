package martin.br.buscacep

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_search.*
import martin.br.buscacep.repository.ui.search.SearchViewModel

class SearchActivity : AppCompatActivity() {

    lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)

        btPesquisar.setOnClickListener {
            searchViewModel.search(etCEP.text.toString())

        }

        searchViewModel.address.observe(this, Observer {
            tvResultado.text = it?.logradouro
        })

        searchViewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

        searchViewModel.isLoading.observe(this, Observer {
            isLoading -> if (isLoading == true){
                loading.visibility = View.VISIBLE
            }else {
                loading.visibility = View.GONE
            }
        })

    }

}
