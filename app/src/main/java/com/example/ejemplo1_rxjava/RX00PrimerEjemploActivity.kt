package com.example.ejemplo1_rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class RX00PrimerEjemploActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx00_primer_ejemplo)

        //en este ejemplo desde el onCreate de la actividad estamos instansiando  un observable y un observador

       var numerosObservable: Observable<String> = Observable.just("1","2","3","4","5","6","7","8","9","10")
        Log.d("TAG1","ObservableCreate ${Thread.currentThread().getName()}")

        //se reliza la instancia de esta manera por que Observer es una interface, por ende no tiene constructor
        // se implementan sus cuatro metodos obligados
       var numerosObserver = object : Observer<String> {
            override fun onSubscribe(d: Disposable) { //se llama unicamente al momento de la subscripcion
                Log.d("TAG1","onSuscribe ${Thread.currentThread().getName()}")
            }

            override fun onNext(t: String) {//se llama para cada item del observable
                Log.d("TAG1","onNext ${Thread.currentThread().getName()} $t")
            }

            override fun onError(e: Throwable) {//se llama unicamente en caso de error
                Log.d("TAG1","onError ${Thread.currentThread().getName()}")
            }

            override fun onComplete() {//se llama cuando se han terminado de recorrer los items del observable
                Log.d("TAG1","onComplete ${Thread.currentThread().getName()}")
            }

        }
        // esta parte es para determinar en que hilo se ejecutaran observador y observable
        // y para suscribir al observador como tal

        numerosObservable
            .subscribeOn(AndroidSchedulers.mainThread())//se inscribe a el observable un el hilo principal (AndroidSchedulers.mainThread())
            .observeOn(Schedulers.io()) //se inscribe a el observador un el hilo de tipo Scheduler.io
            .subscribe(numerosObserver) //se inscribe a numerosObserver como observador de numerosObservable
    }

    //Gracias a los Log.d es posible ver estos resultados el Logcat
}