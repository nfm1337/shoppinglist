package ru.nfm.shoppinglist.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.nfm.shoppinglist.data.ShopListRepositoryImpl
import ru.nfm.shoppinglist.domain.DeleteShopItemUseCase
import ru.nfm.shoppinglist.domain.EditShopItemUseCase
import ru.nfm.shoppinglist.domain.GetShopListUseCase
import ru.nfm.shoppinglist.domain.ShopItem

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository  = ShopListRepositoryImpl(application)

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopListUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopListUseCase.editShopItem(newItem)
    }
}