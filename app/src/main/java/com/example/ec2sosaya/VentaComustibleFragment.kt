package com.example.ec2sosaya

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ec2sosaya.databinding.FragmentPagoObreroBinding
import com.example.ec2sosaya.databinding.FragmentVentaComustibleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VentaComustibleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VentaComustibleFragment : Fragment() {

    lateinit var binding:FragmentVentaComustibleBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVentaComustibleBinding.inflate(layoutInflater);
        val root:View = binding.root;
         var price: Double = 0.0 ;
        binding.rb84.setOnClickListener{
            if(binding.rb84.isChecked == true){
                price = 13.50;
            }
        }
        binding.rb90.setOnClickListener{
            if(binding.rb90.isChecked == true){

                price = 15.17;
            }
        }
        binding.rb95.setOnClickListener{
            if(binding.rb95.isChecked == true){
                price = 20.70;
            }
        }
        binding.rbPetroleo.setOnClickListener{
            if(binding.rbPetroleo.isChecked == true){
                price = 12.00;
            }
        }
        binding.btnCalcular.setOnClickListener(){
            var cantidadgalones:Int = Integer.parseInt(binding.InputNroGalones.text.toString()) ;
            var subtotal = price * cantidadgalones;
            var descuento = 0.0;

            if(cantidadgalones > 10){
                    descuento = subtotal - (subtotal*0.15);
            }
            var total = subtotal -descuento;
            binding.txtImporte.text = "S/"+subtotal.toString();
            binding.txtDescuento.text ="S/"+ descuento.toString();
            binding.txtValorneto.text = "S/"+total.toString();
            binding.txtCliente.text = binding.InputApellidoNombre.text.toString();
        }
        // Inflate the layout for this fragment
        return root;
    }


}