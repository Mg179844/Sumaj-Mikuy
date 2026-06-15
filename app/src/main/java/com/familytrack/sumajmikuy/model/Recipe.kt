package com.familytrack.sumajmikuy.model

data class Recipe(
    val id: Int,
    val name: String,
    val time: String,
    val priceRange: String,
    val imagePublicId: String,
    val category: String,
    val region: String,
    val description: String,
    val ingredients: List<String> = emptyList(),
    val steps: List<String> = emptyList()
)

val sampleRecipes = listOf(
    Recipe(
        id = 1,
        name = "Silpancho Cochabambino",
        time = "45 min",
        priceRange = "$$",
        imagePublicId = "silpancho_p93yxa",
        category = "Plato Fuerte",
        region = "Valles",
        description = "Un clásico de Cochabamba: carne delgada, arroz, papas doradas y huevo.",
        ingredients = listOf(
            "200g de carne molida",
            "2 tazas de arroz",
            "4 papas medianas",
            "2 huevos",
            "1 tomate",
            "1 cebolla",
            "Pan rallado (cantidad necesaria)",
            "Aceite para freír",
            "Sal y pimienta al gusto"
        ),
        steps = listOf(
            "Lavar y cocinar el arroz con agua y sal hasta que esté suave. Reservar.",
            "Pelar las papas, cortarlas en rodajas finas y freírlas en aceite caliente hasta que estén doradas.",
            "Mezclar la carne molida con sal, pimienta y pan rallado. Formar filetes delgados.",
            "Freír los filetes de carne en aceite caliente hasta que estén bien cocidos.",
            "Freír los huevos fritos con la yema jugosa.",
            "Picar el tomate y la cebolla en rodajas finas para la ensalada.",
            "Servir: colocar el arroz como base, la carne encima, las papas al costado, el huevo frito sobre la carne y la ensalada de tomate y cebolla."
        )
    ),
    Recipe(
        id = 2,
        name = "Sopa de Maní",
        time = "60 min",
        priceRange = "$",
        imagePublicId = "sopamani_w9xo9y",
        category = "Sopas",
        region = "Valles",
        description = "La sopa más emblemática de Bolivia, cremosa y con papas fritas al hilo.",
        ingredients = listOf(
            "1 taza de maní crudo molido",
            "300g de carne de res (pulpa)",
            "4 papas medianas",
            "2 zanahorias",
            "1 taza de fideo cabello de ángel",
            "1 cebolla grande",
            "2 dientes de ajo",
            "1 cucharada de perejil picado",
            "Aceite",
            "Sal y comino al gusto"
        ),
        steps = listOf(
            "Tostar el maní en una sartén sin aceite hasta que esté dorado. Molerlo hasta obtener una harina fina.",
            "Cortar la carne en trozos pequeños y dorarla en una olla con aceite.",
            "Picar la cebolla y el ajo en cuadraditos bien pequeños. Agregarlos a la carne y sofreír.",
            "Agregar agua caliente (aproximadamente 2 litros) y dejar hervir la carne hasta que esté tierna.",
            "Pelar las papas y zanahorias. Cortar en rodajas y agregarlas a la olla.",
            "Disolver el maní molido en un poco de agua fría y verterlo en la sopa. Revolver bien para evitar grumos.",
            "Agregar el fideo cabello de ángel y cocinar 5 minutos más.",
            "Condimentar con sal, comino y perejil picado. Servir caliente."
        )
    ),
    Recipe(
        id = 3,
        name = "Salteña de Carne",
        time = "30 min",
        priceRange = "$",
        imagePublicId = "salteñas_ywgamt",
        category = "Snacks",
        region = "Altiplano",
        description = "La empanada boliviana por excelencia, jugosa y llena de sabor.",
        ingredients = listOf(
            "500g de harina de trigo",
            "200g de carne de res molida",
            "2 papas medianas",
            "1 taza de caldo de carne",
            "1 cucharada de ají colorado molido",
            "1 cebolla",
            "2 huevos",
            "Gelatina sin sabor (para el jigote)",
            "Aceite",
            "Sal, pimienta y comino"
        ),
        steps = listOf(
            "Preparar la masa mezclando harina, agua, sal y un poco de aceite. Amasar hasta que esté suave y dejar reposar.",
            "Preparar el jigote: cocinar la carne con la cebolla picada, ají colorado, sal, pimienta y comino.",
            "Agregar el caldo de carne y la gelatina disuelta. Cocinar hasta que espese un poco.",
            "Pelar y picar las papas en cubos pequeños. Cocerlas brevemente y agregarlas al jigote.",
            "Dejar enfriar el jigote en la heladera hasta que tome consistencia.",
            "Estirar la masa y cortar círculos. Rellenar cada uno con el jigote frío.",
            "Cerrar las salteñas con el repulgue característico y pintarlas con huevo batido.",
            "Hornear a 200°C durante 15-20 minutos hasta que estén doradas."
        )
    ),
    Recipe(
        id = 4,
        name = "Pique Macho",
        time = "50 min",
        priceRange = "$$$",
        imagePublicId = "piquemacho_p7t27q",
        category = "Plato Fuerte",
        region = "Valles",
        description = "Mezcla generosa de carne, salchichas, papas y picante.",
        ingredients = listOf(
            "400g de carne de res en trozos",
            "4 salchichas",
            "6 papas grandes",
            "2 locotos (o ají picante)",
            "3 huevos",
            "2 tomates",
            "1 cebolla grande",
            "1 pimiento",
            "Aceite para freír",
            "Sal, pimienta y comino"
        ),
        steps = listOf(
            "Pelar y cortar las papas en bastones gruesos. Freírlas en abundante aceite hasta que estén doradas y crujientes.",
            "Cortar la carne en cubos medianos y sazonarlos con sal, pimienta y comino.",
            "En una sartén grande, freír la carne hasta que esté bien cocida y ligeramente dorada.",
            "Cortar las salchichas en rodajas y freírlas junto con la carne.",
            "Cortar la cebolla, tomate y pimiento en tiras finas y sofreír ligeramente.",
            "En un recipiente grande, mezclar las papas fritas, la carne, las salchichas y las verduras.",
            "Freír los huevos fritos por separado y colocarlos encima del pique.",
            "Picar el locoto en rodajas finas y esparcir sobre el plato."
        )
    ),
    Recipe(
        id = 5,
        name = "Majadito Batido",
        time = "40 min",
        priceRange = "$$",
        imagePublicId = "majadito_z0oys5",
        category = "Plato Fuerte",
        region = "Oriente",
        description = "Arroz con charque, huevo frito y plátano frito, directo del oriente.",
        ingredients = listOf(
            "2 tazas de arroz",
            "200g de charque (carne seca)",
            "2 plátanos maduros",
            "4 huevos",
            "1 cebolla",
            "1 pimiento",
            "1 cucharada de urucú (achiote)",
            "Aceite",
            "Sal al gusto"
        ),
        steps = listOf(
            "Remojar el charque en agua tibia durante 30 minutos para desalarlo. Luego desmenuzarlo en hebras finas.",
            "Picar la cebolla y el pimiento en cuadraditos pequeños.",
            "En una olla con aceite, sofreír la cebolla, el pimiento y el urucú hasta que el aceite tome el color rojo del achiote.",
            "Agregar el charque desmenuzado y sofreír por 5 minutos.",
            "Agregar el arroz y mezclar bien con el sofrito. Verter agua caliente (4 tazas) y sal, cocinar hasta que el arroz esté seco.",
            "Pelar los plátanos y cortarlos en rodajas. Freírlos en aceite hasta que estén dorados.",
            "Freír los huevos fritos con la yema jugosa.",
            "Servir el arroz con charque, colocar el huevo frito encima y los plátanos fritos al costado."
        )
    ),
    Recipe(
        id = 6,
        name = "Sajta de Pollo",
        time = "50 min",
        priceRange = "$$",
        imagePublicId = "sajta-de-pollo-receta_pdkm6a",
        category = "Plato Fuerte",
        region = "Altiplano",
        description = "Picante de pollo tradicional de la zona andina.",
        ingredients = listOf(
            "4 presas de pollo",
            "3 cucharadas de ají amarillo molido",
            "6 papas medianas",
            "1 taza de tunta (chuño) remojado",
            "1 cebolla grande",
            "2 dientes de ajo",
            "1 tomate",
            "Arvejas (al gusto)",
            "Aceite",
            "Sal y comino"
        ),
        steps = listOf(
            "Lavar bien las presas de pollo y sazonarlas con sal y comino.",
            "En una olla, dorar las presas de pollo con un poco de aceite hasta que estén selladas.",
            "Picar la cebolla en cuadraditos finos, el ajo bien picado y el tomate en cubos pequeños.",
            "Agregar la cebolla, el ajo y el tomate a la olla. Sofreír hasta que la cebolla esté transparente.",
            "Disolver el ají amarillo molido en un poco de agua y agregarlo a la olla. Revolver bien.",
            "Agregar agua caliente hasta cubrir el pollo y dejar cocinar a fuego medio por 30 minutos.",
            "Pelar las papas y cocinarlas enteras en agua con sal. Preparar la tunta previamente remojada y cocida.",
            "Servir: una presa de pollo bañada con la salsa de ají, acompañada de papa, tunta y arvejas."
        )
    ),
    Recipe(
        id = 7,
        name = "Chairo Paceño",
        time = "70 min",
        priceRange = "$",
        imagePublicId = "chairopaceño_yfipdl",
        category = "Plato Fuerte",
        region = "Altiplano",
        description = "Sopa espesa tradicional de La Paz, con chuño y carne de res. Un plato que calienta el alma andina.",
        ingredients = listOf(
            "300g de carne de res (pulpa)",
            "1 taza de chuño remojado",
            "1 taza de trigo pelado",
            "2 papas medianas",
            "1 zanahoria",
            "1 cebolla grande",
            "2 dientes de ajo",
            "1 rama de apio",
            "1 cucharada de perejil picado",
            "Sal y comino al gusto"
        ),
        steps = listOf(
            "Remojar el chuño en agua fría desde la noche anterior. Escurrir y picar en cubos pequeños.",
            "Cortar la carne en trozos medianos y dorarla en una olla con un poco de aceite.",
            "Picar la cebolla, el ajo y el apio en cuadraditos pequeños. Agregar a la carne y sofreír por 5 minutos.",
            "Agregar 3 litros de agua caliente y el trigo pelado. Hervir a fuego medio por 40 minutos.",
            "Pelar las papas y la zanahoria. Cortar en cubos y agregarlas a la olla.",
            "Agregar el chuño picado y cocinar 20 minutos más hasta que todos los ingredientes estén tiernos.",
            "Condimentar con sal y comino al gusto. Agregar el perejil picado.",
            "Servir bien caliente en plato hondo."
        )
    ),
    Recipe(
        id = 8,
        name = "Fricasé Paceño",
        time = "65 min",
        priceRange = "$$",
        imagePublicId = "fricasepaceño_iphn4i",
        category = "Plato Fuerte",
        region = "Altiplano",
        description = "Cerdo cocido lentamente en salsa de ají amarillo y mote. Plato festivo del Altiplano.",
        ingredients = listOf(
            "400g de carne de cerdo (costilla y pulpa)",
            "2 tazas de mote cocido",
            "2 cucharadas de ají amarillo molido",
            "3 dientes de ajo",
            "1 cebolla grande",
            "2 tomates",
            "1 cucharadita de comino",
            "1 rama de hierbabuena",
            "Aceite",
            "Sal al gusto"
        ),
        steps = listOf(
            "Cortar la carne de cerdo en trozos medianos. Sazonar con sal, comino y ajo molido.",
            "En una olla grande con aceite, dorar los trozos de cerdo por todos lados hasta que estén sellados.",
            "Picar la cebolla en cuadraditos finos. Pelar y picar los tomates en cubos pequeños.",
            "Agregar la cebolla a la olla y sofreír hasta que esté transparente. Incorporar el tomate picado.",
            "Disolver el ají amarillo en un poco de agua caliente y verterlo sobre la carne. Revolver bien.",
            "Agregar agua caliente hasta cubrir la carne y cocinar a fuego lento por 45 minutos o hasta que la carne esté tierna.",
            "Calentar el mote cocido en una olla aparte con un poco de agua y sal.",
            "Servir la carne bañada con la salsa de ají, acompañada del mote y decorar con hojas de hierbabuena."
        )
    ),
    Recipe(
        id = 9,
        name = "Thimpu",
        time = "60 min",
        priceRange = "$",
        imagePublicId = "thimpu_v8j8uk",
        category = "Plato Fuerte",
        region = "Altiplano",
        description = "Caldo de cordero con verduras andinas. Un plato reconfortante típico de la región altiplánica.",
        ingredients = listOf(
            "500g de cordero (costilla y pulpa)",
            "4 papas medianas",
            "2 zanahorias",
            "1 taza de arroz",
            "1 cebolla grande",
            "2 dientes de ajo",
            "1 rama de apio",
            "1 cucharada de perejil picado",
            "Sal y orégano al gusto"
        ),
        steps = listOf(
            "Lavar bien el cordero y cortarlo en porciones medianas.",
            "En una olla grande con agua hirviendo (3 litros), colocar el cordero y cocinar a fuego medio por 30 minutos.",
            "Picar la cebolla en cuadraditos pequeños y el ajo bien fino. Agregarlos al caldo.",
            "Pelar las zanahorias y cortarlas en rodajas gruesas. Agregarlas junto con la rama de apio.",
            "Pelar las papas enteras y agregarlas al caldo. Cocinar 15 minutos más.",
            "En una olla aparte, cocinar el arroz con agua y sal hasta que esté suave.",
            "Condimentar el caldo con sal y orégano al gusto. Espolvorear con perejil picado.",
            "Servir en plato hondo: colocar la carne, una papa, zanahoria y acompañar con arroz al costado."
        )
    ),
    Recipe(
        id = 10,
        name = "Chicharrón Cochabambino",
        time = "55 min",
        priceRange = "$$",
        imagePublicId = "chicharroncochabambino_jbbiyk",
        category = "Plato Fuerte",
        region = "Valles",
        description = "Cerdo frito crocante servido con mote, papa y ensalada fresca. Un ícono de la gastronomía de Cochabamba.",
        ingredients = listOf(
            "500g de carne de cerdo (pulpa y grasa)",
            "2 tazas de mote cocido",
            "4 papas medianas",
            "1 tomate",
            "1 cebolla",
            "1 locoto",
            "2 limones",
            "Aceite para freír",
            "Sal y pimienta al gusto"
        ),
        steps = listOf(
            "Cortar la carne de cerdo en trozos medianos, dejando parte de la grasa para que quede crocante.",
            "En una sartén profunda, calentar abundante aceite. Freír los trozos de cerdo a fuego medio-alto hasta que estén dorados y crocantes.",
            "Retirar el cerdo y escurrir el exceso de aceite sobre papel absorbente. Sazonar con sal y pimienta.",
            "Pelar las papas, cortarlas en rodajas y freírlas en el mismo aceite hasta que estén doradas.",
            "Calentar el mote cocido en agua hirviendo con un poco de sal. Escurrir.",
            "Preparar la ensalada: picar el tomate y la cebolla en rodajas finas. Aliñar con jugo de limón y sal.",
            "Picar el locoto en rodajas finas para acompañar.",
            "Servir: colocar el cerdo crocante al centro, acompañado de mote, papas fritas, ensalada y rodajas de locoto."
        )
    ),
    Recipe(
        id = 11,
        name = "Pampaku",
        time = "75 min",
        priceRange = "$$",
        imagePublicId = "Pampaku_sou7jd",
        category = "Plato Fuerte",
        region = "Valles",
        description = "Banquete tradicional cocinado bajo tierra con carnes variadas, papas y camote. Una experiencia culinaria ancestral.",
        ingredients = listOf(
            "300g de carne de res",
            "300g de carne de cerdo",
            "4 papas grandes",
            "2 camotes",
            "2 mazorcas de choclo",
            "1 cebolla",
            "2 dientes de ajo",
            "1 cucharada de comino",
            "Sal y pimienta al gusto"
        ),
        steps = listOf(
            "Cortar las carnes en trozos grandes y sazonarlas con sal, comino, ajo molido y pimienta.",
            "Lavar bien las papas y los camotes sin pelarlos. Cortar las mazorcas en rodajas gruesas.",
            "Picar la cebolla en rodajas finas para colocar entre las carnes.",
            "Preparar un recipiente resistente al calor para horno, simulando la cocción bajo tierra.",
            "Colocar las carnes sazonadas en el recipiente, intercalando con cebolla, papas, camotes y choclo.",
            "Cubrir con papel aluminio y hornear a 200°C durante 60 minutos o hasta que todo esté bien cocido.",
            "Destapar y verificar que las carnes estén tiernas y las verduras suaves.",
            "Servir todo en una fuente grande para compartir al centro de la mesa."
        )
    ),
    Recipe(
        id = 12,
        name = "Locro Cruceño",
        time = "50 min",
        priceRange = "$",
        imagePublicId = "locrocruceño_ygol7g",
        category = "Sopas",
        region = "Oriente",
        description = "Sopa espesa de gallina con arroz. Plato tradicional del oriente boliviano.",
        ingredients = listOf(
            "4 presas de gallina",
            "1 taza de arroz",
            "2 plátanos verdes",
            "1 cebolla grande",
            "1 pimiento verde",
            "2 dientes de ajo",
            "1 rama de cebolla verde",
            "Aceite",
            "Sal y pimienta al gusto"
        ),
        steps = listOf(
            "Lavar las presas de gallina y sazonarlas con sal y pimienta.",
            "En una olla grande con aceite, dorar las presas de gallina hasta que estén selladas.",
            "Picar la cebolla y el pimiento en cuadraditos pequeños. Agregar a la olla junto con el ajo picado y sofreír.",
            "Agregar 3 litros de agua caliente y hervir a fuego medio por 30 minutos hasta que la gallina esté tierna.",
            "Pelar los plátanos verdes y cortarlos en rodajas. Agregarlos a la olla junto con el arroz.",
            "Cocinar 20 minutos más, revolviendo ocasionalmente para que el arroz no se pegue.",
            "Verificar que el arroz esté bien cocido y la sopa tenga consistencia espesa.",
            "Servir en plato hondo y espolvorear con cebolla verde picada finamente."
        )
    ),
    Recipe(
        id = 13,
        name = "Sonso de Yuca",
        time = "35 min",
        priceRange = "$",
        imagePublicId = "sonsodeyuca_fbbpll",
        category = "Snacks",
        region = "Oriente",
        description = "Puré de yuca con queso asado al horno. Un acompañante típico del churrasco oriental.",
        ingredients = listOf(
            "500g de yuca pelada",
            "200g de queso criollo rallado",
            "2 cucharadas de mantequilla",
            "1 huevo",
            "1 cucharadita de sal",
            "Aceite para engrasar",
            "Leche (cantidad necesaria)"
        ),
        steps = listOf(
            "Cortar la yuca en trozos medianos y hervirla en agua con sal hasta que esté bien tierna.",
            "Escurrir la yuca y retirar las hebras duras del centro (la vena).",
            "Machacar la yuca caliente hasta obtener un puré sin grumos.",
            "Agregar la mantequilla, el queso rallado y el huevo. Mezclar bien hasta integrar.",
            "Si el puré está muy seco, agregar un chorrito de leche para darle consistencia moldeable.",
            "Formar porciones alargadas y colocarlas en una bandeja engrasada.",
            "Llevar al horno precalentado a 180°C durante 15 minutos o hasta que estén doradas por fuera.",
            "Servir caliente como acompañante del churrasco o solo como merienda."
        )
    ),
    Recipe(
        id = 14,
        name = "Keperi",
        time = "45 min",
        priceRange = "$$",
        imagePublicId = "Keperi_wty7e1",
        category = "Plato Fuerte",
        region = "Oriente",
        description = "Carne de res rellena con verduras al horno. Plato festivo de la región oriental boliviana.",
        ingredients = listOf(
            "500g de carne de res (colita de cuadril)",
            "1 zanahoria",
            "1 pimiento rojo",
            "1 cebolla",
            "2 dientes de ajo",
            "2 cucharadas de mostaza",
            "1 rama de romero",
            "Aceite de oliva",
            "Sal y pimienta al gusto"
        ),
        steps = listOf(
            "Abrir la carne de res en forma de libro para rellenar. Sazonar con sal, pimienta y mostaza por ambos lados.",
            "Cortar la zanahoria en bastones finos y largos. Cortar el pimiento en tiras.",
            "Picar la cebolla y el ajo finamente. Mezclarlos y sofreírlos en un poco de aceite hasta que estén dorados.",
            "Colocar el sofrito de cebolla y ajo sobre la carne abierta. Agregar los bastones de zanahoria y las tiras de pimiento.",
            "Enrollar la carne firmemente y atar con hilo de cocina para que mantenga la forma.",
            "Colocar el rollo en una bandeja para horno. Rociar con aceite de oliva y colocar la rama de romero encima.",
            "Hornear a 180°C durante 30-35 minutos. A la mitad del tiempo, voltear para que dore parejo.",
            "Dejar reposar 5 minutos antes de cortar en rodajas. Servir acompañado de ensalada fresca."
        )
    ),
    Recipe(
        id = 15,
        name = "Cuñapé",
        time = "25 min",
        priceRange = "$",
        imagePublicId = "cuñape_l6gtlq",
        category = "Snacks",
        region = "Oriente",
        description = "Panes de queso y almidón de yuca, crocantes por fuera y suaves por dentro. Un infaltable del desayuno oriental.",
        ingredients = listOf(
            "500g de almidón de yuca",
            "300g de queso criollo rallado",
            "2 huevos",
            "100g de mantequilla derretida",
            "1 cucharadita de sal",
            "Leche (cantidad necesaria)"
        ),
        steps = listOf(
            "Precalentar el horno a 200°C.",
            "En un bol grande, mezclar el almidón de yuca con la sal.",
            "Agregar el queso rallado y mezclar bien con las manos hasta integrar.",
            "Incorporar los huevos y la mantequilla derretida. Amasar suavemente.",
            "Agregar leche de a poco hasta obtener una masa suave que no se pegue a las manos.",
            "Formar bolitas del tamaño de una pelota de golf y colocarlas en una bandeja engrasada.",
            "Hornear durante 15-18 minutos hasta que estén doradas por fuera y al partirlas estén cocidas por dentro.",
            "Servir calientes, ideales para acompañar con un buen café o chocolate."
        )
    )
)
