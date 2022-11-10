package com.example.ec2sosaya

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ec2sosaya.databinding.FragmentPagoObreroBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PagoObreroFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PagoObreroFragment : Fragment() {

    lateinit var binding:FragmentPagoObreroBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPagoObreroBinding.inflate(layoutInflater);
        val root:View = binding.root;
        var costoporhora = 0;
        binding.rbA.setOnClickListener{
            if(binding.rbA.isChecked == true){
                costoporhora = 16;
            }
        }
        binding.rbB.setOnClickListener{
            if(binding.rbB.isChecked == true){

                costoporhora = 15;
            }
        }
        binding.rbC.setOnClickListener{
            if(binding.rbC.isChecked == true){
                costoporhora = 14;
            }
        }
        binding.rbD.setOnClickListener{
            if(binding.rbD.isChecked == true){
                costoporhora = 12;
            }
        }
        binding.btnCalcular2.setOnClickListener(){
            var horassemana = Integer.parseInt(binding.inputNroHorasLaboradas.text.toString());
            var horasextra=0;
            if(horassemana > 48){
                horasextra = horassemana-48;
            }
            var costohoraextra = costoporhora + (costoporhora*0.25);
            var importhnormales = horassemana * costoporhora;
            var importhextras = horasextra *costohoraextra;
            binding.txtCantidadHNormales.text = (horassemana-horasextra).toString()+" horas";
            binding.txtExtras.text = horasextra.toString()+" horas";
            binding.txtCostoHNormal.text = "S/"+costoporhora.toString();
            binding.txtCostoHExtra.text = "S/"+costoporhora.toString();
            binding.txtImporteHNormales.text = "S/"+importhnormales.toString();
            binding.txtImporteHExtras.text = "S/"+importhextras.toString();
            binding.txtValorNeto.text = "S/"+(importhextras +importhnormales).toString();
            binding.txtObrero.text = binding.inputNombreApellido.text.toString();
        }
        // Inflate the layout for this fragment
        return root;
    }


}