package com.anisimov.animalhugger.network.api.mock

import com.anisimov.animalhugger.network.api.AnimalsApi
import com.anisimov.animalhugger.network.model.AnimalResponse
import com.anisimov.animalhugger.network.model.AnimalsResponse
import io.reactivex.Flowable

class AnimalsApiMock : AnimalsApi {

    override fun getAnimals(): Flowable<List<AnimalsResponse>> =
        Flowable.just(
            listOf(
                AnimalsResponse(
                    "Cats",
                    (0..20).map {
                        AnimalResponse(
                            it,
                            "Cat $it",
                            "Description of cat: $it",
                            "https://vignette.wikia.nocookie.net/animal-jam-clans-1/images/2/29/Cats-cat-scratch-cat-stuff-sphynx-cat-cat-talking-siberian-cat-black-cat-funny-cats-cat-images-cute-cats-cute-kittens-cat-names-hairless-cat-food-cat.gif/revision/latest/scale-to-width-down/185?cb=20190925234237"
                        )
                    }),
                AnimalsResponse(
                    "Dogs",
                    (0..20).map {
                        AnimalResponse(
                            it,
                            "Dog $it",
                            "Description of dog: $it",
                            "http://4.bp.blogspot.com/-Mo9sCB55qdE/UCTj7rZ5UzI/AAAAAAAAAIg/Qcw_-KlJYlM/s1600/puppy.jpg"
                        )
                    }),
                AnimalsResponse(
                    "Cow",
                    (0..20).map {
                        AnimalResponse(
                            it,
                            "Cow $it",
                            "Description of cow: $it",
                            "http://photos1.blogger.com/blogger/6911/3130/1600/nurse%20cow.jpg"
                        )
                    }),
                AnimalsResponse(
                    "Crow",
                    (0..20).map {
                        AnimalResponse(
                            it,
                            "Crow $it",
                            "Description of crow: $it",
                            "http://www.figuresworld.net/movies_tv/crow/18crow_m.jpg"
                        )
                    }),
                AnimalsResponse(
                    "Sparrow",
                    (0..20).map {
                        AnimalResponse(
                            it,
                            "Sparrow $it",
                            "Description of sparrow: $it",
                            "http://ourbeautifulworldanduniverse.com/wp-content/uploads/2014/09/Sparrow-in-nature932-150x150.jpg"
                        )
                    }),
                AnimalsResponse(
                    "Something",
                    (0..20).map {
                        AnimalResponse(
                            it,
                            "Something $it",
                            "Description of something: $it",
                            "https://static.tumblr.com/zsvxup4/NgOm4sea0/it_s_something.png"
                        )
                    }),
                AnimalsResponse(
                    "Octopus",
                    (0..20).map {
                        AnimalResponse(
                            it,
                            "Octopus $it",
                            "Description of octopus: $it",
                            "http://images.uncyc.org/commons/thumb/b/ba/Vulcanoctopus_connie.jpg/180px-Vulcanoctopus_connie.jpg"
                        )
                    }),
                AnimalsResponse(
                    "Mailman",
                    (0..20).map {
                        AnimalResponse(
                            it,
                            "Mailman $it",
                            "Description of mailman: $it",
                            "http://sr.photos3.fotosearch.com/bthumb/ULY/ULY216/u23916857.jpg"
                        )
                    }),
                AnimalsResponse(
                    "Lolis",
                    (0..20).map {
                        AnimalResponse(
                            it,
                            "Lolis $it",
                            "Description of lolis: $it",
                            "https://safebooru.org/thumbnails/3182/thumbnail_ff1dfed6ac61f592d1d75ec1ffef9498bf682b5e.jpg?3310254"
                        )
                    }),
            )
        )
}
