package es.grupo12.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.grupo12.model.Product;
import es.grupo12.model.User;
import jakarta.annotation.PostConstruct;

@Component
public class DatabaseInitializer {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() throws IOException {
        
        User usuario1 = new User("martinGP", "martingut@gmail.com", "martiN0par");
        User usuario2 = new User("DavidA","davidarce@gmail.com", "DavArce44");
        User usuario3 = new User("TayPB","taysonpb@gmail.com", "Tayson0Pb");
        User usuario4 = new User("DanMM","danmunmar@gmail.com", "DanIel1");

        userService.save(usuario1);
        userService.save(usuario2);
        userService.save(usuario3);
        userService.save(usuario4);



        Product juego1 = new Product("Persona 3 Reload", "JRPG de PS5", 60, "https://m.media-amazon.com/images/I/81XeA4hpk+L.jpg", null, usuario2 );
		Product juego2 = new Product("Hollowknight Silksong", "Juego nuevo de última generación", 100, "https://www.gamescenter.es/files/images/thumbs/productos_300x400_1659741937-hollow-knight-silksong-nintendo-switch-pre-orden-0.jpg", null, usuario3);
        Product juego3 = new Product("Stardew Valley", "Simulador de granja, relajante", 20, "https://m.media-amazon.com/images/I/81wvEbruC4L._AC_UF350,350_QL50_.jpg", null, usuario4);
        Product juego4 = new Product("Dark Souls III", "Souls-like de alta demanda", 50, "https://m.media-amazon.com/images/I/71f6QgliEFL.jpg", usuario2, usuario4);
        Product juego5 = new Product("Zelda Twilight Princess", "Juego de aventuras de Wii", 60, "https://www.rpgfan.com/wp-content/uploads/2020/07/The-Legend-of-Zelda-Twilight-Princess-Cover-Art-001-320x240.jpg", usuario4, usuario1);
		Product juego6 = new Product("Inscryption", "Juego de estrategia con cartas", 24, "https://i5.walmartimages.com/seo/Inscryption-SRG-Playstation-5-2024-Edition_31c01b81-3831-404e-a8d8-6a5f2c8f40ed.2bb2cf2372ab5221ca1fe9a022a1bddc.jpeg", null, usuario1);
        Product juego7 = new Product("Castlevania: Symphony of the night", "Metroidvania de PlayStation", 300, "https://upload.wikimedia.org/wikipedia/en/c/cf/Castlevania_SOTN_PAL.jpg", null, usuario2);
        Product juego8 = new Product("Super Mario Land", "Juego de plataformas de SNES", 90, "https://i.ebayimg.com/images/g/NQIAAOSw2uZkmJhD/s-l1200.jpg", null, usuario2);
        Product juego9 = new Product("World of Warcraft", "MMORPG", 54, "https://i.ebayimg.com/images/g/a9EAAOSwLMxfjF~I/s-l1200.jpg", null, usuario3);
        Product juego10= new Product("Yakuza Kiwami", "Sandbox ambientado en Japon", 21, "https://www.rpgfan.com/wp-content/uploads/2020/07/Yakuza-Kiwami-Cover-Art-US.jpg", null, usuario4);

        productService.save(juego1);
        productService.save(juego2);
        productService.save(juego3);
        productService.save(juego4);
        productService.save(juego5);
        productService.save(juego6);
        productService.save(juego7);
        productService.save(juego8);
        productService.save(juego9);
        productService.save(juego10);

    }
        

}
