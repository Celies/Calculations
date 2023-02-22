import java.lang.Math;

public class Calculations 
{

	Calculations(){};
	
	/**
	 * Calculates the distance between two coordinates in a 2D plane
	 * @return float
	 */
	public float DistanceBetween2DPoints(float x1, float y1, float x2, float y2)
	{
		return (float) Math.sqrt( ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)) );
	}

	/**
	 * Calculates the distance between two coordinates in a 3D space
	 * @return float
	 */
	public float DistanceBetween3DPoints(float x1, float y1, float z1, float x2, float y2, float z2)
	{
		return (float) Math.sqrt( ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)) + ((z2 - z1) * (z2 - z1)) );
	}
	
	/**
	 * Calculates the radians between two coordinates
	 * @return float containing radians
	 */
	public float DirectionFromOriginToTarget(float originX, float originY, float targetX, float targetY)
	{
		return (float) Math.atan2(targetY - originY, targetX - originX);
	}
	
	/**
	 * Calculated the interception between two actors (origin and target) and returns the angle in radians that the origin-actor 
	 * should head in to intercept. This method is only for 2D spaces. 
	 * @return java.lang.Float class containing the radians, or NaN in case interception is impossible
	 */
	public Float CalculateInterception(float originX, float originY, float originSpeed,
									   float targetX, float targetY, float targetSpeed, float targetDirection)
	{
		double distance, direction, alpha, a, b, c, discriminant, time;
		float x, y;
		
		distance = Math.sqrt(Math.pow(originX - targetX, 2) + Math.pow(originY - targetY, 2));
        direction = DirectionFromOriginToTarget(originX, originY, targetX, targetY);
        alpha = Math.PI + direction - targetDirection;
        
        if(originSpeed == targetSpeed)
        {
        	if(Math.cos(alpha) < 0)
        	{
        		return Float.NaN; // no interception
        	}
        	
        	return (float) ((direction + alpha) % (Math.PI * 2));
        }

        a = Math.pow(originSpeed, 2) - Math.pow(targetSpeed, 2);
        b = 2 * distance * targetSpeed * Math.cos(alpha);
        c = -Math.pow(distance, 2);
        discriminant = Math.pow(b, 2) - 4 * a * c;
        
        if (discriminant < 0)
        {
        	return Float.NaN; // no interception
        }
        
        time = (Math.sqrt(discriminant) - b) / (2 * a);
        x = (float) (targetX + targetSpeed * time * Math.cos(targetDirection));
        y = (float) (targetY + targetSpeed * time * Math.sin(targetDirection));
        
		return Float.valueOf(DirectionFromOriginToTarget(originX, originY, x, y));
	}

}
