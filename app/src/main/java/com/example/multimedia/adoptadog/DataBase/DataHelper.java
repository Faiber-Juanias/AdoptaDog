package com.example.multimedia.adoptadog.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.multimedia.adoptadog.R;

public class DataHelper extends SQLiteOpenHelper{

    public DataHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creamos la tabla Dog
        db.execSQL(Utilidades.CREATE_TBL_PERRO);

        //LLenamos la tabla Dog
        creaRegistros(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void creaRegistros(SQLiteDatabase db){
        ContentValues valUno = new ContentValues();
        valUno.put(Utilidades.IMAGEN, R.drawable.perro_beagle);
        valUno.put(Utilidades.NOMBRE, "Tom");
        valUno.put(Utilidades.EDAD, 6);
        valUno.put(Utilidades.RAZA, "Beagle");
        valUno.put(Utilidades.GENERO, "Macho");
        valUno.put(Utilidades.DESCRIPCION, "Los beagle son una raza de perros de tamaño pequeño a mediano. Tienen un aspecto similar al foxhound, pero de menor tamaño, con patas más cortas y orejas más largas y suaves.");
        db.insert(Utilidades.TBL_PERRO, null, valUno);

        ContentValues valDos = new ContentValues();
        valDos.put(Utilidades.IMAGEN, R.drawable.perro_boxer);
        valDos.put(Utilidades.NOMBRE, "Aron");
        valDos.put(Utilidades.EDAD, 8);
        valDos.put(Utilidades.RAZA, "Boxer");
        valDos.put(Utilidades.GENERO, "Macho");
        valDos.put(Utilidades.DESCRIPCION, "El bóxer alemán o bóxer —en alemán: Deutscher Boxer—, es una raza canina alemana de trabajo y compañía, tipo moloso, que tiende a un tamaño mediano.");
        db.insert(Utilidades.TBL_PERRO, null, valDos);

        ContentValues valTres = new ContentValues();
        valTres.put(Utilidades.IMAGEN, R.drawable.perro_boyero_de_berna);
        valTres.put(Utilidades.NOMBRE, "Angus");
        valTres.put(Utilidades.EDAD, 6);
        valTres.put(Utilidades.RAZA, "Boyero de berna");
        valTres.put(Utilidades.GENERO, "Macho");
        valTres.put(Utilidades.DESCRIPCION, "El bernés de la montaña es una raza de perro boyero muy versátil que se originó en el Cantón de Berna, Suiza.");
        db.insert(Utilidades.TBL_PERRO, null, valTres);

        ContentValues valCuatro = new ContentValues();
        valCuatro.put(Utilidades.IMAGEN, R.drawable.perro_bull_terrier_ingles);
        valCuatro.put(Utilidades.NOMBRE, "Blacy");
        valCuatro.put(Utilidades.EDAD, 8);
        valCuatro.put(Utilidades.RAZA, "Bull terrier ingles");
        valCuatro.put(Utilidades.GENERO, "Hembra");
        valCuatro.put(Utilidades.DESCRIPCION, "El Bull terrier o bull terrier inglés es una raza canina de la familia de los terrier. Son conocidos por la forma única de su cabeza y sus pequeños ojos en forma triangular.");
        db.insert(Utilidades.TBL_PERRO, null, valCuatro);

        ContentValues valCinco = new ContentValues();
        valCinco.put(Utilidades.IMAGEN, R.drawable.perro_bulldog_americano);
        valCinco.put(Utilidades.NOMBRE, "Atila");
        valCinco.put(Utilidades.EDAD, 8);
        valCinco.put(Utilidades.RAZA, "Bulldog americano");
        valCinco.put(Utilidades.GENERO, "Hembra");
        valCinco.put(Utilidades.DESCRIPCION, "El bulldog americano es una raza de perro de granja originario del sureste de los Estados Unidos. Utilizado como perro guardián para el ganado o para la caza.");
        db.insert(Utilidades.TBL_PERRO, null, valCinco);

        ContentValues valSeis = new ContentValues();
        valSeis.put(Utilidades.IMAGEN, R.drawable.perro_chihuahua);
        valSeis.put(Utilidades.NOMBRE, "Baxter");
        valSeis.put(Utilidades.EDAD, 5);
        valSeis.put(Utilidades.RAZA, "Chihuahua");
        valSeis.put(Utilidades.GENERO, "Macho");
        valSeis.put(Utilidades.DESCRIPCION, "El chihuahueño o chihuahua es una raza de perro originaria de México. Es una de las razas de perros más antiguas del continente americano, además de ser el perro más pequeño del mundo.");
        db.insert(Utilidades.TBL_PERRO, null, valSeis);

        ContentValues valSiete = new ContentValues();
        valSiete.put(Utilidades.IMAGEN, R.drawable.perro_chow_chow);
        valSiete.put(Utilidades.NOMBRE, "Bruce");
        valSiete.put(Utilidades.EDAD, 6);
        valSiete.put(Utilidades.RAZA, "Chow Chow");
        valSiete.put(Utilidades.GENERO, "Macho");
        valSiete.put(Utilidades.DESCRIPCION, "El Chow Chow es una raza canina originaria del Norte de China. Se cree que fue uno de los perros nativos utilizados como modelo para el perro de Foo");
        db.insert(Utilidades.TBL_PERRO, null, valSiete);

        ContentValues valOcho = new ContentValues();
        valOcho.put(Utilidades.IMAGEN, R.drawable.perro_grifon_belga);
        valOcho.put(Utilidades.NOMBRE, "Atila");
        valOcho.put(Utilidades.EDAD, 3);
        valOcho.put(Utilidades.RAZA, "Grifon belga");
        valOcho.put(Utilidades.GENERO, "Hembra");
        valOcho.put(Utilidades.DESCRIPCION, "El grifón belga es una raza canina que debe su nombre a su ciudad de origen: Bruselas, Bélgica.");
        db.insert(Utilidades.TBL_PERRO, null, valOcho);

        ContentValues valNueve = new ContentValues();
        valNueve.put(Utilidades.IMAGEN, R.drawable.perro_labrador_retriever);
        valNueve.put(Utilidades.NOMBRE, "Athos");
        valNueve.put(Utilidades.EDAD, 4);
        valNueve.put(Utilidades.RAZA, "Labrador retriever");
        valNueve.put(Utilidades.GENERO, "Macho");
        valNueve.put(Utilidades.DESCRIPCION, "El labrador retriever es una raza canina originaria de Terranova, en la actual Canadá. Es una de las razas más populares del mundo por la cantidad de ejemplares registrados.");
        db.insert(Utilidades.TBL_PERRO, null, valNueve);

        ContentValues valDiez = new ContentValues();
        valDiez.put(Utilidades.IMAGEN, R.drawable.perro_lobo_checoslovaco);
        valDiez.put(Utilidades.NOMBRE, "Aston");
        valDiez.put(Utilidades.EDAD, 8);
        valDiez.put(Utilidades.RAZA, "Lobo checoslovaco");
        valDiez.put(Utilidades.GENERO, "Macho");
        valDiez.put(Utilidades.DESCRIPCION, "El perro lobo checoslovaco es una raza canina relativamente nueva, y cuyo linaje original se remonta a un experimento llevado a cabo en 1955 en Checoslovaquia.");
        db.insert(Utilidades.TBL_PERRO, null, valDiez);

        ContentValues valOnce = new ContentValues();
        valOnce.put(Utilidades.IMAGEN, R.drawable.perro_pastor_belga_tervueren);
        valOnce.put(Utilidades.NOMBRE, "Anubis");
        valOnce.put(Utilidades.EDAD, 2);
        valOnce.put(Utilidades.RAZA, "Pastor belga tervueren");
        valOnce.put(Utilidades.GENERO, "Macho");
        valOnce.put(Utilidades.DESCRIPCION, "El pastor belga tervuerense es una de las cuatro variedades de raza canina en las que se divide el pastor belga.");
        db.insert(Utilidades.TBL_PERRO, null, valOnce);

        ContentValues valDoce = new ContentValues();
        valDoce.put(Utilidades.IMAGEN, R.drawable.perro_pinscher_miniatura);
        valDoce.put(Utilidades.NOMBRE, "Blacky");
        valDoce.put(Utilidades.EDAD, 3);
        valDoce.put(Utilidades.RAZA, "Pinscher miniatura");
        valDoce.put(Utilidades.GENERO, "Hembra");
        valDoce.put(Utilidades.DESCRIPCION, "El pinscher miniatura es una raza de perro chihuahua que prolifera en los mercadillos ambulantes, perteneciente a la familia de los Pinschers originaria de Alemania, donde son llamados zwergpinscher.");
        db.insert(Utilidades.TBL_PERRO, null, valDoce);

        ContentValues valTrece = new ContentValues();
        valTrece.put(Utilidades.IMAGEN, R.drawable.perro_pit_bull_terrier_americano);
        valTrece.put(Utilidades.NOMBRE, "Michael");
        valTrece.put(Utilidades.EDAD, 5);
        valTrece.put(Utilidades.RAZA, "Pit bull terrier americano");
        valTrece.put(Utilidades.GENERO, "Hembra");
        valTrece.put(Utilidades.DESCRIPCION, "El American Pit Bull Terrier es una raza canina, originaria de Estados Unidos y descendiente del Bull-and-terrier, una mezcla entre el antiguo bulldog y terriers.");
        db.insert(Utilidades.TBL_PERRO, null, valTrece);

        ContentValues valCatorce = new ContentValues();
        valCatorce.put(Utilidades.IMAGEN, R.drawable.perro_pomsky);
        valCatorce.put(Utilidades.NOMBRE, "Noah");
        valCatorce.put(Utilidades.EDAD, 7);
        valCatorce.put(Utilidades.RAZA, "Pomsky");
        valCatorce.put(Utilidades.GENERO, "Hembra");
        valCatorce.put(Utilidades.DESCRIPCION, "");
        db.insert(Utilidades.TBL_PERRO, null, valCatorce);

        ContentValues valQuince = new ContentValues();
        valQuince.put(Utilidades.IMAGEN, R.drawable.perro_raton_de_praga);
        valQuince.put(Utilidades.NOMBRE, "Manchas");
        valQuince.put(Utilidades.EDAD, 7);
        valQuince.put(Utilidades.RAZA, "Raton de praga");
        valQuince.put(Utilidades.GENERO, "Macho");
        valQuince.put(Utilidades.DESCRIPCION, "");
        db.insert(Utilidades.TBL_PERRO, null, valQuince);

        ContentValues valDiesiseis = new ContentValues();
        valDiesiseis.put(Utilidades.IMAGEN, R.drawable.perro_rottweiler);
        valDiesiseis.put(Utilidades.NOMBRE, "Wolf");
        valDiesiseis.put(Utilidades.EDAD, 4);
        valDiesiseis.put(Utilidades.RAZA, "Rottweiler");
        valDiesiseis.put(Utilidades.GENERO, "Macho");
        valDiesiseis.put(Utilidades.DESCRIPCION, "");
        db.insert(Utilidades.TBL_PERRO, null, valDiesiseis);

        ContentValues valDiesisiete = new ContentValues();
        valDiesisiete.put(Utilidades.IMAGEN, R.drawable.perro_san_bernardo);
        valDiesisiete.put(Utilidades.NOMBRE, "Luca");
        valDiesisiete.put(Utilidades.EDAD, 5);
        valDiesisiete.put(Utilidades.RAZA, "San bernardo");
        valDiesisiete.put(Utilidades.GENERO, "Hembra");
        valDiesisiete.put(Utilidades.DESCRIPCION, "");
        db.insert(Utilidades.TBL_PERRO, null, valDiesisiete);

        ContentValues valDiesiocho = new ContentValues();
        valDiesiocho.put(Utilidades.IMAGEN, R.drawable.perro_schnauzer_gigante);
        valDiesiocho.put(Utilidades.NOMBRE, "Ken");
        valDiesiocho.put(Utilidades.EDAD, 6);
        valDiesiocho.put(Utilidades.RAZA, "Schnauzer gigante");
        valDiesiocho.put(Utilidades.GENERO, "Macho");
        valDiesiocho.put(Utilidades.DESCRIPCION, "");
        db.insert(Utilidades.TBL_PERRO, null, valDiesiocho);

        ContentValues valDiesinueve = new ContentValues();
        valDiesinueve.put(Utilidades.IMAGEN, R.drawable.perro_sin_pelo_del_peru);
        valDiesinueve.put(Utilidades.NOMBRE, "Laika");
        valDiesinueve.put(Utilidades.EDAD, 7);
        valDiesinueve.put(Utilidades.RAZA, "Sin pelo del peru");
        valDiesinueve.put(Utilidades.GENERO, "Hembra");
        valDiesinueve.put(Utilidades.DESCRIPCION, "");
        db.insert(Utilidades.TBL_PERRO, null, valDiesinueve);

        ContentValues ValVeinte = new ContentValues();
        ValVeinte.put(Utilidades.IMAGEN, R.drawable.perro_welsh_corgi_pembroke);
        ValVeinte.put(Utilidades.NOMBRE, "Buck");
        ValVeinte.put(Utilidades.EDAD, 7);
        ValVeinte.put(Utilidades.RAZA, "Welsh corgi pembroke");
        ValVeinte.put(Utilidades.GENERO, "Macho");
        ValVeinte.put(Utilidades.DESCRIPCION, "");
        db.insert(Utilidades.TBL_PERRO, null, ValVeinte);
    }
}
