package es.grupo12.service;

import es.grupo12.utils.ImageUtils;
import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.grupo12.dto.ProductDTO;
import es.grupo12.model.Message;
import es.grupo12.model.Product;
import es.grupo12.model.Review;
import es.grupo12.model.User;
import jakarta.annotation.PostConstruct;

@Component
public class DatabaseInitializer {

    @Autowired
    private ImageUtils imageUtils;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private ReviewService reviewService;

    @PostConstruct
    public void init() throws IOException {
        
        User admin = new User("admin", "admin@host", "1234", "ADMIN", "USER");
        User usuario1 = new User("martinGP", "martingut@gmail.com", "marting", "USER");
        User usuario2 = new User("DavidA","davidarce@gmail.com", "davida", "USER");
        User usuario3 = new User("TayPB","taysonpb@gmail.com", "taysonp", "USER");
        User usuario4 = new User("DanMM","danmunmar@gmail.com", "danielm", "USER");

        userService.save(admin);
        userService.save(usuario1);
        userService.save(usuario2);
        userService.save(usuario3);
        userService.save(usuario4);

        LocalDateTime date1 = LocalDateTime.of(2025, 2, 20, 12, 30, 32);
        Message message1 = new Message("Aceptas ofertas??", date1, usuario1, usuario2);
        LocalDateTime date2 = LocalDateTime.of(2025, 2, 20, 12, 31, 45);
        Message message2 = new Message("Lo tienes muy caro", date2, usuario3, usuario1);
        LocalDateTime date3 = LocalDateTime.of(2025, 2, 20, 12, 33, 12);
        Message message3 = new Message("Claro!", date3, usuario2, usuario1);

        messageService.save(message1);
        messageService.save(message2);
        messageService.save(message3);


        Product juego1 = new Product("Persona 3 Reload", "JRPG de PS5", 60, null, usuario2 );
        saveProductWithURLImage(juego1,"https://m.media-amazon.com/images/I/81XeA4hpk+L.jpg");

        Product juego2 = new Product("Hollow Knight Silksong", "Juego nuevo de última generación", 100, null, usuario3);
        saveProductWithURLImage(juego2,"https://www.gamescenter.es/files/images/thumbs/productos_300x400_1659741937-hollow-knight-silksong-nintendo-switch-pre-orden-0.jpg");

        Product juego3 = new Product("Stardew Valley", "Simulador de granja, relajante", 20, null, usuario4);
        saveProductWithURLImage(juego3,"https://m.media-amazon.com/images/I/81wvEbruC4L._AC_UF350,350_QL50_.jpg");

        Product juego4 = new Product("Dark Souls III", "Souls-like de alta demanda", 50, usuario2, usuario4);
        saveProductWithURLImage(juego4,"https://m.media-amazon.com/images/I/71f6QgliEFL.jpg");

        Product juego5 = new Product("Zelda Twilight Princess", "Juego de aventuras de Wii", 60, usuario4, usuario1);
        saveProductWithURLImage(juego5,"https://www.rpgfan.com/wp-content/uploads/2020/07/The-Legend-of-Zelda-Twilight-Princess-Cover-Art-001-320x240.jpg");

        Product juego6 = new Product("Inscryption", "Juego de estrategia con cartas", 24, null, usuario1);
        saveProductWithURLImage(juego6,"https://i5.walmartimages.com/seo/Inscryption-SRG-Playstation-5-2024-Edition_31c01b81-3831-404e-a8d8-6a5f2c8f40ed.2bb2cf2372ab5221ca1fe9a022a1bddc.jpeg");

        Product juego7 = new Product("Castlevania: Symphony of the night", "Metroidvania de PlayStation", 300, null, usuario2);
        saveProductWithURLImage(juego7,"https://upload.wikimedia.org/wikipedia/en/c/cf/Castlevania_SOTN_PAL.jpg");

        Product juego8 = new Product("Super Mario Land", "Juego de plataformas de SNES", 90, null, usuario2);
        saveProductWithURLImage(juego8,"https://i.ebayimg.com/images/g/NQIAAOSw2uZkmJhD/s-l1200.jpg");

        Product juego9 = new Product("World of Warcraft", "MMORPG", 54, null, usuario3);
        saveProductWithURLImage(juego9,"https://i.ebayimg.com/images/g/a9EAAOSwLMxfjF~I/s-l1200.jpg");

        Product juego10= new Product("Yakuza Kiwami", "Sandbox ambientado en Japon", 21, null, usuario4);
        saveProductWithURLImage(juego10,"https://www.rpgfan.com/wp-content/uploads/2020/07/Yakuza-Kiwami-Cover-Art-US.jpg");

        Product juego11= new Product("Balatro", "Juego roguelike de cartas", 23, null, usuario1);
        saveProductWithURLImage(juego11,"https://m.media-amazon.com/images/I/81HhicKlfGL._AC_UF1000,1000_QL80_.jpg");

        Product juego12= new Product("Zelda Ocarina of Time", "Uno de los mejores de Nintendo 64", 80, null, usuario3);
        saveProductWithURLImage(juego12,"https://i.ebayimg.com/images/g/k7cAAOSwJ19kYC3u/s-l1200.jpg");

        Product juego13= new Product("Final Fantasy VII", "JRPG clásico de la PSX", 50, null, usuario1);
        saveProductWithURLImage(juego13,"https://upload.wikimedia.org/wikipedia/en/c/c2/Final_Fantasy_VII_Box_Art.jpg");

        Product juego14= new Product("Wii Sports", "Juego cooperativo de la Wii", 44, null, usuario4);
        saveProductWithURLImage(juego14,"https://i.etsystatic.com/47461913/r/il/939f74/6482957355/il_fullxfull.6482957355_j3qk.jpg");

        Product juego15= new Product("Bloodborne", "Soulslike exclusivo", 30, null, usuario2);
        saveProductWithURLImage(juego15,"https://image.api.playstation.com/vulcan/img/rnd/202010/2614/Sy5e8DmeKIJVjlAGraPAJYkT.png");


        
        Product consola1 = new Product("PlayStation 4 Pro","Comprada en el 2019 sigue como nueva por poco uso",249.99,usuario4,usuario2);  
        saveProductWithURLImage(consola1,"https://m.media-amazon.com/images/I/71GrRdRbV3L.jpg");
        
        Review review1 = new Review("Es un comprador excelente. Puntual y profesional",null,null);
        reviewService.save(review1,usuario2,usuario4);

        Review review2 = new Review("Amable y rápido.",null,null);
        reviewService.save(review2,usuario3,usuario1);
    }
        
    private ProductDTO saveProductWithURLImage(Product product, String image) throws IOException {
        product.setImg(imageUtils.remoteImageToBlob(image));
        return productService.save(product,null);
    }
        

}
