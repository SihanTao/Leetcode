public class Can_Place_Flowers_605 {
  public boolean canPlaceFlowers_v1(int[] flowerbed, int n) {
    int new_flowers = 0;
    int i = 0;
    int numFlowersBed = flowerbed.length;
    while (i < numFlowersBed) {
      if (flowerbed[i] == 1) {
        i += 2;
      } else {

        if (i == numFlowersBed - 1) {
          new_flowers++;
          break;
        }

        if (flowerbed[i + 1] == 1) {
          i += 3;
        } else  {
          flowerbed[i] = 1;
          new_flowers++;
          i += 2;
        }
      }
    }



    return new_flowers >= n;
  }

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int i = 0;
    int numFlowersBed = flowerbed.length;
    while (i < numFlowersBed - 1) {
      if (flowerbed[i] == 1) {
        i += 2;
      } else {
        if (flowerbed[i + 1] == 1) {
          i += 3;
        } else  {
          n--;
          i += 2;
        }
      }
    }

    if (i == numFlowersBed - 1 && flowerbed[i] == 0) {
      n--;
    }

    return n <= 0;
  }
}
