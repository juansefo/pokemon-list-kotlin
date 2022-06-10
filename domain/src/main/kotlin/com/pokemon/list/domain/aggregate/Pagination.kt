package com.pokemon.list.domain.aggregate

import com.pokemon.list.domain.vo.ItemPerPage
import com.pokemon.list.domain.vo.Page

data class Pagination (val itemPerPage : ItemPerPage, val page : Page) {
}