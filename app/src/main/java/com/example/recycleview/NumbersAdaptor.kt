package com.example.recycleview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumbersAdaptor(numberOfItems: Int, private var viewHolderCount: Int = 0) : RecyclerView.Adapter<NumbersAdaptor.NumberViewHolder>() {
    private var numberItems : Int = numberOfItems


    class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val viewHolderIndex: TextView = itemView.findViewById(R.id.tv_view_holder_number)   // TextView 2 список индексов
        private var listItemNumberView: TextView = itemView.findViewById(R.id.tv_number_item)       // TextView 1 список чисел

        fun bind(listIndex: Int){
            listItemNumberView.text = listIndex.toString()
        }                                                       // Меняем значения TextView 1 в диапозоне 1-100

    } // оборачиваем элемент списка и передаем новые значения при прокрутке списка


    @SuppressLint("SetTextI18n")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val context: Context = parent.context
        val layoutIdForListItem : Int = R.layout.number_list_item   // передаем ID XML файла
        val inflater: LayoutInflater = LayoutInflater.from(context) // создаем объект класса View из XML файла
        val view: View = inflater.inflate(layoutIdForListItem,parent,false) // Создаем новый элемент из списка XML. 1-Указываем из какого XML мы хотим создать новый объект. 2-Задаем родителя. 3-Разрешение на помещение нового элемента внутрь родителя
        val viewHolder = NumberViewHolder(view)   // Оборачивание Элемента из списка для переиспользования его в дальнейшем
        viewHolder.viewHolderIndex.text ="ViewHolder index: $viewHolderCount"  // Вводим новый текст значения TextView 2
        viewHolderCount++
        return viewHolder
    } // Создаем новые ViewHolder-ы

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.bind(position)
    }              // У созданных ViewHolder-ов меняем значения при прокрутке

    override fun getItemCount(): Int {
        return numberItems
    }                                                    // Общее количество элементов в списке
}
