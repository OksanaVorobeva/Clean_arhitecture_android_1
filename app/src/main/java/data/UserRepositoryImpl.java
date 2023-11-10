package data;

import android.content.Context;

import domain.Repository;
import domain.entety.User;

public class UserRepositoryImpl implements  Repository{

   private Context context;
   private StoragePref storagePref;

   public UserRepositoryImpl(Context context) {
      this.context = context;
      storagePref = new StoragePref(context);
   }

   @Override
   public User loadUser() {
      String name = storagePref.loadUserName();
      return  new User(name);
   }

   @Override
   public boolean saveUser(User user) {
      return storagePref.saveUserName(user.getName());
   }
}
