//the "private variable" of an object in java
///Object Vector
///## param
///<p>x and y which represent the distance from 1 point to another</p>
/// (basically a vector usually points toward a point)
pub struct Vector {
    pub x: f64,
    pub y: f64,
}
impl Vector {
    pub fn new(x: f64, y: f64) -> Self {
        Self { x, y }
    }
    ///return the magnitude of the desired vector
    pub fn magnitude(&self) -> f64 {
        (self.x.powi(2) + self.y.powi(2)).sqrt()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_magniture() {
        let v = Vector::new(10.0, 20.0);
        //floating point math isn't precise due to how decimal
        // are stored in binary
        //instead of using assert_eq! ( checking exact equality )
        // we check if the difference is smaller than a tiny error margin, in
        // this case, 0.0001, to account for rounding
        //the .abs is just to ensure its positive and not negative.
        assert!((v.magnitude() - 22.3606).abs() < 0.0001);
    }
}

