package ru.nfm.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import ru.nfm.shoppinglist.data.ShopListRepositoryImpl
import ru.nfm.shoppinglist.domain.DeleteShopItemUseCase
import ru.nfm.shoppinglist.domain.EditShopItemUseCase
import ru.nfm.shoppinglist.domain.GetShopListUseCase
import ru.nfm.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository  = ShopListRepositoryImpl

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